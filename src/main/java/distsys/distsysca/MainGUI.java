/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;

/**
 *
 * @author Nardy
 */
import generated.belt.*;
import generated.arm.*;
import generated.bracelet.*;
import io.grpc.*;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;

import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

/**
 * MainGUI - Main controller window.
 * Discovers 3 services using jmDNS and communicates with them using gRPC.
 * GUI uses background threads so the interface never freezes.
 */
public class MainGUI extends JFrame {

    // gRPC stubs
    private ArmServiceGrpc.ArmServiceBlockingStub armStub;
    private ArmServiceGrpc.ArmServiceStub armAsyncStub;
    private BraceletServiceGrpc.BraceletServiceStub braceletStub;
    private BeltServiceGrpc.BeltServiceStub beltStub;

    // gRPC channels
    private ManagedChannel armChannel, braceletChannel, beltChannel;

    // GUI components
    private DefaultTableModel discoveryTableModel;

    private JLabel armStatusLabel;
    private JButton streamArmButton;
    private JLabel armStreamLabel;

    private JLabel bpmLabel;
    private JLabel alertLabel;
    private JLabel braceletMsgLabel;
    private JSlider bpmSlider;
    private StreamObserver<HeartData> braceletSender;

    private DefaultTableModel navTableModel;
    private JTextField destinationField;

    private static final String[] GESTURES = {"GRIP", "RELEASE", "FLEX", "EXTEND", "PINCH"};

    // Metadata keys
    private static final Metadata.Key<String> TOKEN_KEY =
            Metadata.Key.of("token", Metadata.ASCII_STRING_MARSHALLER);
    private static final Metadata.Key<String> CLIENT_ID_KEY =
            Metadata.Key.of("client-id", Metadata.ASCII_STRING_MARSHALLER);


    public MainGUI() {
        setTitle("Distributed System CA - Nardy Apala");
        setSize(750, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Shutdown channels when closing the window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                shutdownChannels();
            }
        });

        // Build GUI panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(buildDiscoveryPanel());
        mainPanel.add(buildArmPanel());
        mainPanel.add(buildBraceletPanel());
        mainPanel.add(buildBeltPanel());

        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
        setVisible(true);

        // Start service discovery
        discoverServices();
    }

    /** Build metadata for authentication */
    private Metadata buildMetadata() {
        Metadata metadata = new Metadata();
        metadata.put(TOKEN_KEY, "valid-token");
        metadata.put(CLIENT_ID_KEY, "main-gui-001");
        return metadata;
    }

    /** Discover services using jmDNS */
    private void discoverServices() {
        new Thread(() -> {
            String[] serviceNames = {"BeltService", "BraceletService", "ArmService"};

            for (String name : serviceNames) {
                ServiceInfo info = ServiceRegistry.discover(name);

                if (info != null) {
                    String host = info.getHostAddresses()[0];
                    int port = info.getPort();
                    String address = host + ":" + port;

                    SwingUtilities.invokeLater(() ->
                            discoveryTableModel.addRow(new Object[]{name, address, "Connected"}));

                    connectToService(name, host, port);
                } else {
                    SwingUtilities.invokeLater(() ->
                            discoveryTableModel.addRow(new Object[]{name, "---", "Not Found"}));
                }
            }

            // Start bracelet stream if available
            if (braceletStub != null) {
                startBraceletMonitor();
            }

        }).start();
    }

    /** Connect to a discovered service */
    private void connectToService(String name, String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();

        Metadata metadata = buildMetadata();

        switch (name) {
            case "BeltService":
                beltChannel = channel;
                beltStub = MetadataUtils.attachHeaders(
                        BeltServiceGrpc.newStub(channel), metadata);
                break;

            case "ArmService":
                armChannel = channel;
                armStub = MetadataUtils.attachHeaders(
                        ArmServiceGrpc.newBlockingStub(channel), metadata);
                armAsyncStub = MetadataUtils.attachHeaders(
                        ArmServiceGrpc.newStub(channel), metadata);
                break;

            case "BraceletService":
                braceletChannel = channel;
                braceletStub = MetadataUtils.attachHeaders(
                        BraceletServiceGrpc.newStub(channel), metadata);
                break;
        }
    }

    /*Panel Service Discovery */
    private JPanel buildDiscoveryPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Service Discovery (jmDNS)"));

        discoveryTableModel = new DefaultTableModel(
                new String[]{"Service", "Address", "Status"}, 0);

        JTable table = new JTable(discoveryTableModel);
        table.setRowHeight(22);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(700, 120));
        return panel;
    }

    /* Panel 1 - Robotic Arm */
    private JPanel buildArmPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Robotic Arm"));

        // Emergency Stop
        JPanel topRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
        JButton stopArmButton = new JButton("EMERGENCY STOP");
        stopArmButton.setBackground(Color.RED);
        stopArmButton.setForeground(Color.WHITE);
        armStatusLabel = new JLabel("Status: waiting...");
        stopArmButton.addActionListener(e -> sendEmergencyStop());
        topRow.add(stopArmButton);
        topRow.add(armStatusLabel);

        // Client-side streaming
        JPanel bottomRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
        streamArmButton = new JButton("Stream Sensor Data");
        streamArmButton.setBackground(new Color(0, 120, 215));
        streamArmButton.setForeground(Color.WHITE);
        armStreamLabel = new JLabel("Stream: not started");
        streamArmButton.addActionListener(e -> sendArmStream());
        bottomRow.add(streamArmButton);
        bottomRow.add(armStreamLabel);

        panel.add(topRow);
        panel.add(bottomRow);
        return panel;
    }

    /* Unary RPC: Emergency Stop */
    private void sendEmergencyStop() {
        if (armStub == null) {
            armStatusLabel.setText("Status: Arm service not connected");
            return;
        }

        new Thread(() -> {
            try {
                ArmResponse response = armStub
                        .withDeadlineAfter(5, TimeUnit.SECONDS)
                        .emergencyStop(ArmRequest.newBuilder().setCommand("STOP").build());

                SwingUtilities.invokeLater(() -> {
                    armStatusLabel.setText("Status: " + response.getStatusText());
                });

            } catch (StatusRuntimeException e) {
                SwingUtilities.invokeLater(() ->
                        armStatusLabel.setText("Error: " + e.getStatus().getDescription()));
            }
        }).start();
    }

    /* Client-side streaming: send multiple gestures */
    private void sendArmStream() {
        if (armAsyncStub == null) {
            armStreamLabel.setText("Stream: Arm service not connected");
            return;
        }

        new Thread(() -> {
            StreamObserver<ArmData> sender = armAsyncStub.streamArmState(
                    new StreamObserver<ArmResponse>() {
                        @Override
                        public void onNext(ArmResponse response) {
                            SwingUtilities.invokeLater(() -> {
                                armStreamLabel.setText("Stream: " + response.getStatusText());
                            });
                        }

                        @Override
                        public void onError(Throwable t) {
                            SwingUtilities.invokeLater(() ->
                                    armStreamLabel.setText("Stream Error: " + t.getMessage()));
                        }

                        @Override
                        public void onCompleted() {}
                    }
            );

            for (String gesture : GESTURES) {
                sender.onNext(ArmData.newBuilder()
                        .setSensorId(gesture)
                        .setLoad(1)
                        .build());

                SwingUtilities.invokeLater(() ->
                        armStreamLabel.setText("Sending: " + gesture));

                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }

            sender.onCompleted();
        }).start();
    }

    /* Panel 2 - Bracelet (Bidirectional Streaming) */
    private JPanel buildBraceletPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Epilepsy Bracelet"));

        JPanel labels = new JPanel(new GridLayout(3, 1, 5, 5));
        bpmLabel = new JLabel("BPM: --", SwingConstants.CENTER);
        alertLabel = new JLabel("Alert: --", SwingConstants.CENTER);
        braceletMsgLabel = new JLabel("Message: --", SwingConstants.CENTER);

        labels.add(bpmLabel);
        labels.add(alertLabel);
        labels.add(braceletMsgLabel);

        JPanel sliderPanel = new JPanel(new FlowLayout());
        sliderPanel.add(new JLabel("Simulate BPM:"));
        bpmSlider = new JSlider(40, 180, 75);
        bpmSlider.setMajorTickSpacing(20);
        bpmSlider.setPaintTicks(true);
        bpmSlider.setPaintLabels(true);

        bpmSlider.addChangeListener(e -> {
            if (!bpmSlider.getValueIsAdjusting() && braceletSender != null) {
                int bpm = bpmSlider.getValue();
                braceletSender.onNext(HeartData.newBuilder().setBpm(bpm).build());
                bpmLabel.setText("BPM: " + bpm);
            }
        });

        sliderPanel.add(bpmSlider);

        panel.add(labels, BorderLayout.CENTER);
        panel.add(sliderPanel, BorderLayout.SOUTH);
        return panel;
    }

    /* Start bidirectional stream with bracelet server */
    private void startBraceletMonitor() {
        new Thread(() -> {
            braceletSender = braceletStub.monitorHealth(
                    new StreamObserver<HealthAlert>() {
                        @Override
                        public void onNext(HealthAlert alert) {
                            SwingUtilities.invokeLater(() -> {
                                alertLabel.setText("Alert: " + alert.getAlertLevel());
                                braceletMsgLabel.setText("Message: " + alert.getMessage());
                            });
                        }

                        @Override
                        public void onError(Throwable t) {
                            SwingUtilities.invokeLater(() ->
                                    alertLabel.setText("Bracelet Error: " + t.getMessage()));
                        }

                        @Override
                        public void onCompleted() {
                            SwingUtilities.invokeLater(() ->
                                    braceletMsgLabel.setText("Stream ended"));
                        }
                    }
            );
        }).start();
    }

    /* Panel 3 - Belt Navigation (Server-side streaming) */
    private JPanel buildBeltPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Belt Navigation"));

        JPanel topRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        destinationField = new JTextField("Exit", 20);
        JButton navigateButton = new JButton("Navigate");
        navigateButton.setBackground(new Color(0, 120, 215));
        navigateButton.setForeground(Color.WHITE);
        navigateButton.addActionListener(e -> startNavigation());

        topRow.add(new JLabel("Destination:"));
        topRow.add(destinationField);
        topRow.add(navigateButton);

        navTableModel = new DefaultTableModel(new String[]{"Direction", "Intensity"}, 0);
        JTable table = new JTable(navTableModel);
        table.setRowHeight(25);

        panel.add(topRow, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    /* Server-side streaming: receive navigation instructions */
    private void startNavigation() {
        if (beltStub == null) {
            navTableModel.addRow(new Object[]{"Belt service not connected", "-"});
            return;
        }

        navTableModel.setRowCount(0);
        String destination = destinationField.getText();

        new Thread(() -> {
            beltStub.getNavigation(
                    NavRequest.newBuilder().setDestination(destination).build(),
                    new StreamObserver<NavInstruction>() {
                        @Override
                        public void onNext(NavInstruction instruction) {
                            SwingUtilities.invokeLater(() ->
                                    navTableModel.addRow(new Object[]{
                                            instruction.getDirection(),
                                            instruction.getIntensity()
                                    }));
                        }

                        @Override
                        public void onError(Throwable t) {
                            SwingUtilities.invokeLater(() ->
                                    navTableModel.addRow(new Object[]{"ERROR: " + t.getMessage(), "-"}));
                        }

                        @Override
                        public void onCompleted() {
                            SwingUtilities.invokeLater(() ->
                                    navTableModel.addRow(new Object[]{"ARRIVED", "-"}));
                        }
                    }
            );
        }).start();
    }

    /* Shutdown all gRPC channels */
    private void shutdownChannels() {
        if (braceletSender != null) braceletSender.onCompleted();
        if (armChannel != null) armChannel.shutdown();
        if (braceletChannel != null) braceletChannel.shutdown();
        if (beltChannel != null) beltChannel.shutdown();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
