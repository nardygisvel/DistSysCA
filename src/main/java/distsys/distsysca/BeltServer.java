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
import io.grpc.*;
import io.grpc.stub.StreamObserver;

public class BeltServer {
    public static void main(String[] args) throws Exception {
        int port = 50051;

        // build and start the gRPC server on port 50051
        // we add the AuthInterceptor so every request must have a valid token
        Server server = ServerBuilder.forPort(port)
                .addService(ServerInterceptors.intercept(
                    new BeltServiceImpl(), new AuthInterceptor()))
                .build()
                .start();

        // register this service with jmDNS so the GUI can find it
        ServiceRegistry.register("BeltService", port);
        System.out.println("Belt Server started on port " + port);

        // keep the server running until it's shut down
        server.awaitTermination();
    }

    // this is where the actual logic for the belt service lives
    static class BeltServiceImpl extends BeltServiceGrpc.BeltServiceImplBase {

        // SERVER-SIDE STREAMING: client sends one request, server sends back multiple responses
        // like a GPS giving turn-by-turn directions
        @Override
        public void getNavigation(NavRequest req, StreamObserver<NavInstruction> responseObserver) {

            // ERROR HANDLING: check that the client actually sent a destination
            if (req.getDestination() == null || req.getDestination().isEmpty()) {
                responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("Destination cannot be empty")
                    .asRuntimeException());
                return;
            }

            System.out.println("Navigating to: " + req.getDestination());
            String[] directions = {"STRAIGHT", "LEFT", "RIGHT", "ARRIVED"};

            for (String dir : directions) {
                // check if the client cancelled the request (e.g. timeout or disconnect)
                if (Context.current().isCancelled()) {
                    System.out.println("Client cancelled navigation.");
                    return;
                }

                // build one instruction and send it to the client
                NavInstruction instruction = NavInstruction.newBuilder()
                        .setDirection(dir)
                        .setIntensity(3)
                        .build();

                responseObserver.onNext(instruction);

                // wait 1 second between instructions (simulating real-time navigation)
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }

            // done sending all instructions
            responseObserver.onCompleted();
        }
    }
}
