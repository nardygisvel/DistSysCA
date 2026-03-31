package generated.armmotorhelp;

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
public final class ArmMotorHelpServiceGrpc {

  private ArmMotorHelpServiceGrpc() {}

  public static final String SERVICE_NAME = "armmotorhelp.ArmMotorHelpService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.armmotorhelp.ArmState,
      generated.armmotorhelp.ArmSessionSummary> getStreamArmStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamArmState",
      requestType = generated.armmotorhelp.ArmState.class,
      responseType = generated.armmotorhelp.ArmSessionSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.armmotorhelp.ArmState,
      generated.armmotorhelp.ArmSessionSummary> getStreamArmStateMethod() {
    io.grpc.MethodDescriptor<generated.armmotorhelp.ArmState, generated.armmotorhelp.ArmSessionSummary> getStreamArmStateMethod;
    if ((getStreamArmStateMethod = ArmMotorHelpServiceGrpc.getStreamArmStateMethod) == null) {
      synchronized (ArmMotorHelpServiceGrpc.class) {
        if ((getStreamArmStateMethod = ArmMotorHelpServiceGrpc.getStreamArmStateMethod) == null) {
          ArmMotorHelpServiceGrpc.getStreamArmStateMethod = getStreamArmStateMethod = 
              io.grpc.MethodDescriptor.<generated.armmotorhelp.ArmState, generated.armmotorhelp.ArmSessionSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "armmotorhelp.ArmMotorHelpService", "StreamArmState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.armmotorhelp.ArmState.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.armmotorhelp.ArmSessionSummary.getDefaultInstance()))
                  .setSchemaDescriptor(new ArmMotorHelpServiceMethodDescriptorSupplier("StreamArmState"))
                  .build();
          }
        }
     }
     return getStreamArmStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.armmotorhelp.EmergencyStopRequest,
      generated.armmotorhelp.EmergencyStopAck> getEmergencyStopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmergencyStop",
      requestType = generated.armmotorhelp.EmergencyStopRequest.class,
      responseType = generated.armmotorhelp.EmergencyStopAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.armmotorhelp.EmergencyStopRequest,
      generated.armmotorhelp.EmergencyStopAck> getEmergencyStopMethod() {
    io.grpc.MethodDescriptor<generated.armmotorhelp.EmergencyStopRequest, generated.armmotorhelp.EmergencyStopAck> getEmergencyStopMethod;
    if ((getEmergencyStopMethod = ArmMotorHelpServiceGrpc.getEmergencyStopMethod) == null) {
      synchronized (ArmMotorHelpServiceGrpc.class) {
        if ((getEmergencyStopMethod = ArmMotorHelpServiceGrpc.getEmergencyStopMethod) == null) {
          ArmMotorHelpServiceGrpc.getEmergencyStopMethod = getEmergencyStopMethod = 
              io.grpc.MethodDescriptor.<generated.armmotorhelp.EmergencyStopRequest, generated.armmotorhelp.EmergencyStopAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "armmotorhelp.ArmMotorHelpService", "EmergencyStop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.armmotorhelp.EmergencyStopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.armmotorhelp.EmergencyStopAck.getDefaultInstance()))
                  .setSchemaDescriptor(new ArmMotorHelpServiceMethodDescriptorSupplier("EmergencyStop"))
                  .build();
          }
        }
     }
     return getEmergencyStopMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ArmMotorHelpServiceStub newStub(io.grpc.Channel channel) {
    return new ArmMotorHelpServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ArmMotorHelpServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ArmMotorHelpServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ArmMotorHelpServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ArmMotorHelpServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ArmMotorHelpServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Client-side streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.armmotorhelp.ArmState> streamArmState(
        io.grpc.stub.StreamObserver<generated.armmotorhelp.ArmSessionSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamArmStateMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void emergencyStop(generated.armmotorhelp.EmergencyStopRequest request,
        io.grpc.stub.StreamObserver<generated.armmotorhelp.EmergencyStopAck> responseObserver) {
      asyncUnimplementedUnaryCall(getEmergencyStopMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamArmStateMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                generated.armmotorhelp.ArmState,
                generated.armmotorhelp.ArmSessionSummary>(
                  this, METHODID_STREAM_ARM_STATE)))
          .addMethod(
            getEmergencyStopMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.armmotorhelp.EmergencyStopRequest,
                generated.armmotorhelp.EmergencyStopAck>(
                  this, METHODID_EMERGENCY_STOP)))
          .build();
    }
  }

  /**
   */
  public static final class ArmMotorHelpServiceStub extends io.grpc.stub.AbstractStub<ArmMotorHelpServiceStub> {
    private ArmMotorHelpServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArmMotorHelpServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArmMotorHelpServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArmMotorHelpServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client-side streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.armmotorhelp.ArmState> streamArmState(
        io.grpc.stub.StreamObserver<generated.armmotorhelp.ArmSessionSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getStreamArmStateMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void emergencyStop(generated.armmotorhelp.EmergencyStopRequest request,
        io.grpc.stub.StreamObserver<generated.armmotorhelp.EmergencyStopAck> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEmergencyStopMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ArmMotorHelpServiceBlockingStub extends io.grpc.stub.AbstractStub<ArmMotorHelpServiceBlockingStub> {
    private ArmMotorHelpServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArmMotorHelpServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArmMotorHelpServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArmMotorHelpServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public generated.armmotorhelp.EmergencyStopAck emergencyStop(generated.armmotorhelp.EmergencyStopRequest request) {
      return blockingUnaryCall(
          getChannel(), getEmergencyStopMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ArmMotorHelpServiceFutureStub extends io.grpc.stub.AbstractStub<ArmMotorHelpServiceFutureStub> {
    private ArmMotorHelpServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArmMotorHelpServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArmMotorHelpServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArmMotorHelpServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.armmotorhelp.EmergencyStopAck> emergencyStop(
        generated.armmotorhelp.EmergencyStopRequest request) {
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
    private final ArmMotorHelpServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ArmMotorHelpServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EMERGENCY_STOP:
          serviceImpl.emergencyStop((generated.armmotorhelp.EmergencyStopRequest) request,
              (io.grpc.stub.StreamObserver<generated.armmotorhelp.EmergencyStopAck>) responseObserver);
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
              (io.grpc.stub.StreamObserver<generated.armmotorhelp.ArmSessionSummary>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ArmMotorHelpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ArmMotorHelpServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.armmotorhelp.ArmMotorHelpProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ArmMotorHelpService");
    }
  }

  private static final class ArmMotorHelpServiceFileDescriptorSupplier
      extends ArmMotorHelpServiceBaseDescriptorSupplier {
    ArmMotorHelpServiceFileDescriptorSupplier() {}
  }

  private static final class ArmMotorHelpServiceMethodDescriptorSupplier
      extends ArmMotorHelpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ArmMotorHelpServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ArmMotorHelpServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ArmMotorHelpServiceFileDescriptorSupplier())
              .addMethod(getStreamArmStateMethod())
              .addMethod(getEmergencyStopMethod())
              .build();
        }
      }
    }
    return result;
  }
}
