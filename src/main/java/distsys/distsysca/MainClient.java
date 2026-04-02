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


public class MainClient {
    public static void main(String[] args) {

        // 1. DISCOVERY: getting the address in the registry
        String beltAddr = ServiceRegistry.lookup("VibrationBelt");
        String armAddr = ServiceRegistry.lookup("ArmMotor");
        String braceletAddr = ServiceRegistry.lookup("EpilepsyBracelet");

        // 2. CHANNELS: create the stubs
        ManagedChannel beltChannel = ManagedChannelBuilder.forTarget(beltAddr).usePlaintext().build();
        ManagedChannel armChannel = ManagedChannelBuilder.forTarget(armAddr).usePlaintext().build();
        ManagedChannel braceletChannel = ManagedChannelBuilder.forTarget(braceletAddr).usePlaintext().build();

        // SERVICE 1: VIBRATION BELT (Streaming de servidor)
        BeltServiceGrpc.BeltServiceStub beltStub = BeltServiceGrpc.newStub(beltChannel);

        System.out.println("[Client] Requesting Navigation...");
        beltStub.getNavigation(NavRequest.newBuilder().setDestination("Exit").build(), 
            new StreamObserver<NavInstruction>() {
                @Override 
                public void onNext(NavInstruction note) { 
                    System.out.println("BELT MONITOR: " + note.getDirection()); 
                }
                @Override public void onError(Throwable t) { System.out.println("Belt Error"); }
                @Override public void onCompleted() { System.out.println("BELT: Finished."); }
            });

        // SERVICE 2: ROBOTIC ARM (Síncrono / Unary)
        ArmServiceGrpc.ArmServiceBlockingStub armStub = ArmServiceGrpc.newBlockingStub(armChannel);

        System.out.println("[Client] Stopping Arm...");
        ArmResponse armRes = armStub.emergencyStop(ArmRequest.newBuilder().setCommand("STOP").build());
        System.out.println("ARM MONITOR: " + armRes.getStatusText());

        // SERVICE 3: EPILEPSY BRACELET (Bidireccional)
        BraceletServiceGrpc.BraceletServiceStub braceletStub = BraceletServiceGrpc.newStub(braceletChannel);

        StreamObserver<HeartData> requestObserver = braceletStub.monitorHealth(new StreamObserver<HealthAlert>() {
            @Override 
            public void onNext(HealthAlert alert) { 
                System.out.println("BRACELET ALERT: " + alert.getMessage()); 
            }
            @Override public void onError(Throwable t) {}
            @Override public void onCompleted() {}
        });

        System.out.println("[Client] Sending Heart Data...");
        requestObserver.onNext(HeartData.newBuilder().setBpm(120).build());
        requestObserver.onCompleted();

        try {
            Thread.sleep(7000); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cierre de canales
        beltChannel.shutdown();
        armChannel.shutdown();
        braceletChannel.shutdown();
    }
}