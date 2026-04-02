/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;

import generated.arm.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ArmServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50053)
                .addService(new ArmServiceImpl())
                .build().start();

        ServiceRegistry.register("ArmMotor", "localhost:50053");
        server.awaitTermination();
    }

    static class ArmServiceImpl extends ArmServiceGrpc.ArmServiceImplBase {
        // UNARY: Simple Request/Response
        @Override
        public void emergencyStop(ArmRequest req, StreamObserver<ArmResponse> responseObserver) {
            responseObserver.onNext(ArmResponse.newBuilder()
                    .setStatusText("EMERGENCY STOP ACTIVE")
                    .setIsActive(false).build());
            responseObserver.onCompleted();
        }

        // CLIENT STREAMING: Receiving multiple ArmData, returning ONE ArmResponse
        @Override
        public StreamObserver<ArmData> streamArmState(StreamObserver<ArmResponse> responseObserver) {
            return new StreamObserver<ArmData>() {
                int count = 0;
                @Override
                public void onNext(ArmData value) { count++; }
                @Override
                public void onError(Throwable t) {}
                @Override
                public void onCompleted() {
                    responseObserver.onNext(ArmResponse.newBuilder()
                            .setStatusText("Processed " + count + " sensor readings")
                            .setIsActive(true).build());
                    responseObserver.onCompleted();
                }
            };
        }
    }
}