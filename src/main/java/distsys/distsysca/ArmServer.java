/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;

/**
 *
 * @author Nardy
 */
import generated.arm.*;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

public class ArmServer {
    public static void main(String[] args) throws Exception {
        int port = 50053;
        Server server = ServerBuilder.forPort(port)
                .addService(ServerInterceptors.intercept(
                    new ArmServiceImpl(), new AuthInterceptor()))
                .build()
                .start();
        ServiceRegistry.register("ArmService", port);
        System.out.println("Arm Server started on port " + port);

        server.awaitTermination();
    }

    static class ArmServiceImpl extends ArmServiceGrpc.ArmServiceImplBase {

        // UNARY RPC: one request in, one response out
        // GUI sends a STOP command, server stops the exoskeleton and confirms
        @Override
        public void emergencyStop(ArmRequest req, StreamObserver<ArmResponse> responseObserver) {
            System.out.println("Emergency stop received: " + req.getCommand());
            if (req.getCommand() == null || req.getCommand().isEmpty()) {
                responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("Command cannot be empty")
                    .asRuntimeException());
                return;
            }
            responseObserver.onNext(ArmResponse.newBuilder()
                    .setStatusText("EMERGENCY STOP - Device halted")
                    .setIsActive(false)
                    .build());
            responseObserver.onCompleted();
        }

        // CLIENT-SIDE STREAMING: client sends multiple gesture commands,
        // server collects them all and sends back ONE summary at the end
        @Override
        public StreamObserver<ArmData> streamArmState(StreamObserver<ArmResponse> responseObserver) {
            return new StreamObserver<ArmData>() {
                int total = 0;      // how many gestures were received
                int successful = 0; // how many were executed successfully

                @Override
                public void onNext(ArmData data) {
                    total++;
                    // sensorId holds the gesture name
                    // load holds the result: 1 = executed ok, 0 = failed
                    boolean ok = data.getLoad() == 1;
                    if (ok) successful++;
                    System.out.println("Gesture received: " + data.getSensorId()
                        + " -> " + (ok ? "executed" : "failed"));
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Arm motor stream error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // client finished sending all gestures
                    // now send back ONE summary response
                    responseObserver.onNext(ArmResponse.newBuilder()
                            .setStatusText(successful + "/" + total
                                + " movements executed successfully")
                            .setIsActive(true)
                            .build());
                    responseObserver.onCompleted();
                }
            };
        }
    }
}