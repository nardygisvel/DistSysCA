/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;

import generated.belt.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.Context;

public class BeltServer {
    public static void main(String[] args) throws Exception {
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
                .addService(new BeltServiceImpl())
                .build()
                .start();

        ServiceRegistry.register("VibrationBelt", "localhost:" + port);
        System.out.println("Belt Server started on " + port);
        server.awaitTermination();
    }

    // INNER CLASS: Logic for the service
    static class BeltServiceImpl extends BeltServiceGrpc.BeltServiceImplBase {
        @Override
        public void getNavigation(NavRequest req, StreamObserver<NavInstruction> responseObserver) {
            String[] directions = {"STRAIGHT", "LEFT", "RIGHT", "ARRIVED"};

            for (String dir : directions) {
                // CANCELLATION CHECK: If client disconnects or timeout hits, stop loop
                if (Context.current().isCancelled()) {
                    System.out.println("Client cancelled navigation.");
                    return;
                }

                NavInstruction instruction = NavInstruction.newBuilder()
                        .setDirection(dir)
                        .setIntensity(3)
                        .build();

                responseObserver.onNext(instruction); // Send one part of the stream

                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
            responseObserver.onCompleted(); // Close the stream
        }
    }
}
