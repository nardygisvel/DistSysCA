package generated.arm;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: armmotorhelp.proto")
public final class ArmServiceGrpc {

  private ArmServiceGrpc() {}

  public static final String SERVICE_NAME = "armmotorhelp.ArmService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.arm.ArmData,
      generated.arm.ArmResponse> getStreamArmStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamArmState",
      requestType = generated.arm.ArmData.class,
      responseType = generated.arm.ArmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.arm.ArmData,
      generated.arm.ArmResponse> getStreamArmStateMethod() {
    io.grpc.MethodDescriptor<generated.arm.ArmData, generated.arm.ArmResponse> getStreamArmStateMethod;
    if ((getStreamArmStateMethod = ArmServiceGrpc.getStreamArmStateMethod) == null) {
      synchronized (ArmServiceGrpc.class) {
        if ((getStreamArmStateMethod = ArmServiceGrpc.getStreamArmStateMethod) == null) {
          ArmServiceGrpc.getStreamArmStateMethod = getStreamArmStateMethod = 
              io.grpc.MethodDescriptor.<generated.arm.ArmData, generated.arm.ArmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "armmotorhelp.ArmService", "StreamArmState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.arm.ArmData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.arm.ArmResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ArmServiceMethodDescriptorSupplier("StreamArmState"))
                  .build();
          }
        }
     }
     return getStreamArmStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.arm.ArmRequest,
      generated.arm.ArmResponse> getEmergencyStopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmergencyStop",
      requestType = generated.arm.ArmRequest.class,
      responseType = generated.arm.ArmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.arm.ArmRequest,
      generated.arm.ArmResponse> getEmergencyStopMethod() {
    io.grpc.MethodDescriptor<generated.arm.ArmRequest, generated.arm.ArmResponse> getEmergencyStopMethod;
    if ((getEmergencyStopMethod = ArmServiceGrpc.getEmergencyStopMethod) == null) {
      synchronized (ArmServiceGrpc.class) {
        if ((getEmergencyStopMethod = ArmServiceGrpc.getEmergencyStopMethod) == null) {
          ArmServiceGrpc.getEmergencyStopMethod = getEmergencyStopMethod = 
              io.grpc.MethodDescriptor.<generated.arm.ArmRequest, generated.arm.ArmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "armmotorhelp.ArmService", "EmergencyStop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.arm.ArmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.arm.ArmResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ArmServiceMethodDescriptorSupplier("EmergencyStop"))
                  .build();
          }
        }
     }
     return getEmergencyStopMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ArmServiceStub newStub(io.grpc.Channel channel) {
    return new ArmServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ArmServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ArmServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ArmServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ArmServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ArmServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * * CLIENT-SIDE STREAMING
     * The robotic arm sends many 'ArmData' updates (sensor readings).
     * When the arm finishes, the server sends ONE 'ArmResponse' (summary).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.arm.ArmData> streamArmState(
        io.grpc.stub.StreamObserver<generated.arm.ArmResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamArmStateMethod(), responseObserver);
    }

    /**
     * <pre>
     * * UNARY RPC
     * A simple request-response. The user clicks a button in the GUI,
     * the server stops the motors and confirms.
     * </pre>
     */
    public void emergencyStop(generated.arm.ArmRequest request,
        io.grpc.stub.StreamObserver<generated.arm.ArmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEmergencyStopMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamArmStateMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                generated.arm.ArmData,
                generated.arm.ArmResponse>(
                  this, METHODID_STREAM_ARM_STATE)))
          .addMethod(
            getEmergencyStopMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.arm.ArmRequest,
                generated.arm.ArmResponse>(
                  this, METHODID_EMERGENCY_STOP)))
          .build();
    }
  }

  /**
   */
  public static final class ArmServiceStub extends io.grpc.stub.AbstractStub<ArmServiceStub> {
    private ArmServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArmServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArmServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArmServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * * CLIENT-SIDE STREAMING
     * The robotic arm sends many 'ArmData' updates (sensor readings).
     * When the arm finishes, the server sends ONE 'ArmResponse' (summary).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.arm.ArmData> streamArmState(
        io.grpc.stub.StreamObserver<generated.arm.ArmResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getStreamArmStateMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * * UNARY RPC
     * A simple request-response. The user clicks a button in the GUI,
     * the server stops the motors and confirms.
     * </pre>
     */
    public void emergencyStop(generated.arm.ArmRequest request,
        io.grpc.stub.StreamObserver<generated.arm.ArmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEmergencyStopMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ArmServiceBlockingStub extends io.grpc.stub.AbstractStub<ArmServiceBlockingStub> {
    private ArmServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArmServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArmServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArmServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * * UNARY RPC
     * A simple request-response. The user clicks a button in the GUI,
     * the server stops the motors and confirms.
     * </pre>
     */
    public generated.arm.ArmResponse emergencyStop(generated.arm.ArmRequest request) {
      return blockingUnaryCall(
          getChannel(), getEmergencyStopMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ArmServiceFutureStub extends io.grpc.stub.AbstractStub<ArmServiceFutureStub> {
    private ArmServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArmServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArmServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArmServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * * UNARY RPC
     * A simple request-response. The user clicks a button in the GUI,
     * the server stops the motors and confirms.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.arm.ArmResponse> emergencyStop(
        generated.arm.ArmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEmergencyStopMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EMERGENCY_STOP = 0;
  private static final int METHODID_STREAM_ARM_STATE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ArmServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ArmServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EMERGENCY_STOP:
          serviceImpl.emergencyStop((generated.arm.ArmRequest) request,
              (io.grpc.stub.StreamObserver<generated.arm.ArmResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_ARM_STATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamArmState(
              (io.grpc.stub.StreamObserver<generated.arm.ArmResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ArmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ArmServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.arm.Armmotorhelp.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ArmService");
    }
  }

  private static final class ArmServiceFileDescriptorSupplier
      extends ArmServiceBaseDescriptorSupplier {
    ArmServiceFileDescriptorSupplier() {}
  }

  private static final class ArmServiceMethodDescriptorSupplier
      extends ArmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ArmServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ArmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ArmServiceFileDescriptorSupplier())
              .addMethod(getStreamArmStateMethod())
              .addMethod(getEmergencyStopMethod())
              .build();
        }
      }
    }
    return result;
  }
}
