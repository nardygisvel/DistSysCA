/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;

import generated.bracelet.*;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

public class BraceletServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50052)
                .addService(new BraceletServiceImpl())
                .build().start();

        ServiceRegistry.register("EpilepsyBracelet", "localhost:50052");
        server.awaitTermination();
    }

    static class BraceletServiceImpl extends BraceletServiceGrpc.BraceletServiceImplBase {
        @Override
        public StreamObserver<HeartData> monitorHealth(StreamObserver<HealthAlert> responseObserver) {
            return new StreamObserver<HeartData>() {
                @Override
                public void onNext(HeartData data) {
                    System.out.println("Received BPM: " + data.getBpm());
                    
                    // Logic: If BPM is too high, send alert back immediately
                    if (data.getBpm() > 100) {
                        responseObserver.onNext(HealthAlert.newBuilder()
                                .setAlertLevel("CRITICAL")
                                .setMessage("High heart rate detected!")
                                .build());
                    }
                }

                @Override
                public void onError(Throwable t) { System.err.println("Stream Error: " + t); }

                @Override
                public void onCompleted() { responseObserver.onCompleted(); }
            };
        }
    }
}