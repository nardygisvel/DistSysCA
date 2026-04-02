/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;

import generated.belt.*;
import generated.arm.*;
import generated.bracelet.*;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * MainGUI - A simple JFrame that connects to 3 gRPC services:
 *   1. ArmService      - Emergency Stop button + status label
 *   2. BraceletService - Shows BPM and alert level with color
 *   3. BeltService     - Shows navigation instructions in a table
 */
public class MainGUI extends JFrame {

    
    // ??? gRPC Stubs (the "phones" we use to call the server) ???????????????????
    private ArmServiceGrpc.ArmServiceBlockingStub armStub;
    private BraceletServiceGrpc.BraceletServiceStub braceletStub;
    private BeltServiceGrpc.BeltServiceStub beltStub;

    private ManagedChannel armChannel, braceletChannel, beltChannel;

    // ??? GUI Components ?????????????????????????????????????????????????????????

    // ARM panel
    private JLabel  armStatusLabel;   // shows "All motors stopped", etc.
    private JButton stopArmButton;    // sends EmergencyStop command

    // BRACELET panel
    private JLabel bpmLabel;          // shows current BPM number
    private JLabel alertLabel;        // shows NORMAL or CRITICAL (changes color)
    private JLabel braceletMsgLabel;  // shows advice message from server

    // BELT panel
    private DefaultTableModel tableModel; // holds rows of navigation data
    private JTextField destinationField;  // user types destination here
    private JButton navigateButton;       // starts navigation streaming


    // ??? Constructor: build the window ??????????????????????????????????????????
    public MainGUI() {
        setTitle("Assistive Device Monitor");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // gaps between sections

        // Connect to gRPC servers (uses same ServiceRegistry as MainClient)
        connectToServers();

        // Build each panel and add to the window
        add(buildArmPanel(),       BorderLayout.NORTH);
        add(buildBraceletPanel(),  BorderLayout.CENTER);
        add(buildBeltPanel(),      BorderLayout.SOUTH);

        setVisible(true);
    }


    // ??? Connect to all 3 gRPC servers ??????????????????????????????????????????
    private void connectToServers() {
        String armAddr      = ServiceRegistry.lookup("ArmMotor");
        String braceletAddr = ServiceRegistry.lookup("EpilepsyBracelet");
        String beltAddr     = ServiceRegistry.lookup("VibrationBelt");

        armChannel      = ManagedChannelBuilder.forTarget(armAddr).usePlaintext().build();
        braceletChannel = ManagedChannelBuilder.forTarget(braceletAddr).usePlaintext().build();
        beltChannel     = ManagedChannelBuilder.forTarget(beltAddr).usePlaintext().build();

        armStub      = ArmServiceGrpc.newBlockingStub(armChannel);
        braceletStub = BraceletServiceGrpc.newStub(braceletChannel);
        beltStub     = BeltServiceGrpc.newStub(beltChannel);
    }


    // ???????????????????????????????????????????????????????????????????????????
    // PANEL 1 - ROBOTIC ARM
    // Shows a button to send EmergencyStop, and displays the server's response
    // ???????????????????????????????????????????????????????????????????????????
    private JPanel buildArmPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        panel.setBorder(BorderFactory.createTitledBorder("?? Robotic Arm"));
        panel.setBackground(new Color(245, 245, 245));

        stopArmButton = new JButton("EMERGENCY STOP");
        stopArmButton.setBackground(Color.RED);
        stopArmButton.setForeground(Color.WHITE);
        stopArmButton.setFont(new Font("Arial", Font.BOLD, 14));

        armStatusLabel = new JLabel("Status: waiting...");
        armStatusLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // When button is clicked ? call gRPC EmergencyStop
        stopArmButton.addActionListener(e -> sendEmergencyStop());

        panel.add(stopArmButton);
        panel.add(armStatusLabel);
        return panel;
    }

    // Sends STOP command to the arm server (Unary RPC)
    private void sendEmergencyStop() {
        // Run in background thread so the GUI doesn't freeze
        new Thread(() -> {
            ArmResponse response = armStub.emergencyStop(
                ArmRequest.newBuilder().setCommand("STOP").build()
            );
            // Update the label on the Swing thread (always do GUI updates here)
            SwingUtilities.invokeLater(() -> {
                armStatusLabel.setText("Status: " + response.getStatusText());
                armStatusLabel.setForeground(response.getIsActive() ? Color.ORANGE : Color.GREEN.darker());
            });
        }).start();
    }


    // ???????????????????????????????????????????????????????????????????????????
    // PANEL 2 - EPILEPSY BRACELET
    // Shows live BPM and alert level. Turns red if CRITICAL.
    // ???????????????????????????????????????????????????????????????????????????
    private JPanel buildBraceletPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("?? Epilepsy Bracelet Monitor"));
        panel.setBackground(new Color(245, 245, 245));

        bpmLabel        = new JLabel("BPM: --",       SwingConstants.CENTER);
        alertLabel      = new JLabel("Alert: --",     SwingConstants.CENTER);
        braceletMsgLabel= new JLabel("Message: --",   SwingConstants.CENTER);

        bpmLabel.setFont(new Font("Arial", Font.BOLD, 22));
        alertLabel.setFont(new Font("Arial", Font.BOLD, 18));
        braceletMsgLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(bpmLabel);
        panel.add(alertLabel);
        panel.add(braceletMsgLabel);

        // Start listening to the bracelet right away (Bidirectional streaming)
        startBraceletMonitor();

        return panel;
    }

    // Opens a bidirectional stream with the bracelet server
    private void startBraceletMonitor() {
        new Thread(() -> {
            // This observer receives alerts FROM the server
            StreamObserver<HeartData> sender = braceletStub.monitorHealth(
                new StreamObserver<HealthAlert>() {
                    @Override
                    public void onNext(HealthAlert alert) {
                        // Update bracelet labels on the Swing thread
                        SwingUtilities.invokeLater(() -> {
                            alertLabel.setText("Alert: " + alert.getAlertLevel());
                            braceletMsgLabel.setText("Message: " + alert.getMessage());

                            // Change color: GREEN = normal, RED = critical
                            if (alert.getAlertLevel().equals("CRITICAL")) {
                                alertLabel.setForeground(Color.RED);
                            } else {
                                alertLabel.setForeground(Color.GREEN.darker());
                            }
                        });
                    }
                    @Override public void onError(Throwable t) {
                        SwingUtilities.invokeLater(() -> alertLabel.setText("Bracelet Error"));
                    }
                    @Override public void onCompleted() {}
                }
            );

            // Send a sample BPM reading to the server
            // In a real app, you'd loop this with real sensor data
            sender.onNext(HeartData.newBuilder().setBpm(120).build());

            SwingUtilities.invokeLater(() -> bpmLabel.setText("BPM: 120"));

        }).start();
    }


    // ???????????????????????????????????????????????????????????????????????????
    // PANEL 3 - VIBRATION BELT NAVIGATION
    // User types a destination, clicks Navigate, and instructions appear in table
    // ???????????????????????????????????????????????????????????????????????????
    private JPanel buildBeltPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("?? Belt Navigation"));
        panel.setBackground(new Color(245, 245, 245));

        // Top row: text field + button
        JPanel topRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        destinationField = new JTextField("Exit", 20);
        navigateButton   = new JButton("Navigate");
        navigateButton.setBackground(new Color(0, 120, 215));
        navigateButton.setForeground(Color.WHITE);

        navigateButton.addActionListener(e -> startNavigation());

        topRow.add(new JLabel("Destination:"));
        topRow.add(destinationField);
        topRow.add(navigateButton);

        // Table to show Direction + Intensity columns
        tableModel = new DefaultTableModel(new String[]{"Direction", "Intensity"}, 0);
        JTable table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.setRowHeight(25);

        panel.add(topRow, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        return panel;
    }

    // Calls GetNavigation and adds each instruction as a new table row
    private void startNavigation() {
        tableModel.setRowCount(0); // clear old rows
        String destination = destinationField.getText();

        new Thread(() -> {
            beltStub.getNavigation(
                NavRequest.newBuilder().setDestination(destination).build(),
                new StreamObserver<NavInstruction>() {
                    @Override
                    public void onNext(NavInstruction instruction) {
                        // Each instruction = one new row in the table
                        SwingUtilities.invokeLater(() ->
                            tableModel.addRow(new Object[]{
                                instruction.getDirection(),
                                instruction.getIntensity()
                            })
                        );
                    }
                    @Override public void onError(Throwable t) {
                        SwingUtilities.invokeLater(() ->
                            tableModel.addRow(new Object[]{"ERROR", "-"})
                        );
                    }
                    @Override public void onCompleted() {
                        SwingUtilities.invokeLater(() ->
                            tableModel.addRow(new Object[]{"? ARRIVED", "-"})
                        );
                    }
                }
            );
        }).start();
    }


    // ??? Main: launch the GUI ????????????????????????????????????????????????????
    public static void main(String[] args) {
        // Always start Swing apps on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new MainGUI());
    }
}

