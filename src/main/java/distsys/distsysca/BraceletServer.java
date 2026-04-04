/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;

/**
 *
 * @author Nardy
 */
import generated.bracelet.*;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

public class BraceletServer {
    public static void main(String[] args) throws Exception {
        int port = 50052;

        // build and start the gRPC server on port 50052
        // we add the AuthInterceptor so every request must have a valid token
        Server server = ServerBuilder.forPort(port)
                .addService(ServerInterceptors.intercept(
                    new BraceletServiceImpl(), new AuthInterceptor()))
                .build()
                .start();

        // register this service with jmDNS so the GUI can find it
        ServiceRegistry.register("BraceletService", port);
        System.out.println("Bracelet Server started on port " + port);

        // keep the server running until it's shut down
        server.awaitTermination();
    }

    // this is where the actual logic for the bracelet service lives
    static class BraceletServiceImpl extends BraceletServiceGrpc.BraceletServiceImplBase {

        // BIDIRECTIONAL STREAMING: both client and server send messages at the same time
        // client sends heart rate data, server sends back alerts if something is wrong
        @Override
        public StreamObserver<HeartData> monitorHealth(StreamObserver<HealthAlert> responseObserver) {
            return new StreamObserver<HeartData>() {

                @Override
                public void onNext(HeartData data) {
                    System.out.println("Received BPM: " + data.getBpm());

                    // ERROR HANDLING: reject invalid heart rate values
                    if (data.getBpm() <= 0) {
                        responseObserver.onError(Status.INVALID_ARGUMENT
                            .withDescription("BPM must be greater than 0")
                            .asRuntimeException());
                        return;
                    }

                    // if heart rate is too high, send a critical alert back
                    if (data.getBpm() > 100) {
                        responseObserver.onNext(HealthAlert.newBuilder()
                                .setAlertLevel("CRITICAL")
                                .setMessage("High heart rate detected! Please sit down.")
                                .build());
                    } else {
                        // heart rate is normal, send an OK message
                        responseObserver.onNext(HealthAlert.newBuilder()
                                .setAlertLevel("NORMAL")
                                .setMessage("Heart rate is normal.")
                                .build());
                    }
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Bracelet stream error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
