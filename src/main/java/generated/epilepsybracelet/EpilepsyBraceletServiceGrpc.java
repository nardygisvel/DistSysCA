package generated.epilepsybracelet;

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
    comments = "Source: epilepsybracelet.proto")
public final class EpilepsyBraceletServiceGrpc {

  private EpilepsyBraceletServiceGrpc() {}

  public static final String SERVICE_NAME = "epilepsybracelet.EpilepsyBraceletService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.epilepsybracelet.BiometricData,
      generated.epilepsybracelet.SeizureAlert> getStreamBiometricDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamBiometricData",
      requestType = generated.epilepsybracelet.BiometricData.class,
      responseType = generated.epilepsybracelet.SeizureAlert.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<generated.epilepsybracelet.BiometricData,
      generated.epilepsybracelet.SeizureAlert> getStreamBiometricDataMethod() {
    io.grpc.MethodDescriptor<generated.epilepsybracelet.BiometricData, generated.epilepsybracelet.SeizureAlert> getStreamBiometricDataMethod;
    if ((getStreamBiometricDataMethod = EpilepsyBraceletServiceGrpc.getStreamBiometricDataMethod) == null) {
      synchronized (EpilepsyBraceletServiceGrpc.class) {
        if ((getStreamBiometricDataMethod = EpilepsyBraceletServiceGrpc.getStreamBiometricDataMethod) == null) {
          EpilepsyBraceletServiceGrpc.getStreamBiometricDataMethod = getStreamBiometricDataMethod = 
              io.grpc.MethodDescriptor.<generated.epilepsybracelet.BiometricData, generated.epilepsybracelet.SeizureAlert>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "epilepsybracelet.EpilepsyBraceletService", "StreamBiometricData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.epilepsybracelet.BiometricData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.epilepsybracelet.SeizureAlert.getDefaultInstance()))
                  .setSchemaDescriptor(new EpilepsyBraceletServiceMethodDescriptorSupplier("StreamBiometricData"))
                  .build();
          }
        }
     }
     return getStreamBiometricDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.epilepsybracelet.EmergencyAlertRequest,
      generated.epilepsybracelet.EmergencyAlertAck> getSendEmergencyAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendEmergencyAlert",
      requestType = generated.epilepsybracelet.EmergencyAlertRequest.class,
      responseType = generated.epilepsybracelet.EmergencyAlertAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.epilepsybracelet.EmergencyAlertRequest,
      generated.epilepsybracelet.EmergencyAlertAck> getSendEmergencyAlertMethod() {
    io.grpc.MethodDescriptor<generated.epilepsybracelet.EmergencyAlertRequest, generated.epilepsybracelet.EmergencyAlertAck> getSendEmergencyAlertMethod;
    if ((getSendEmergencyAlertMethod = EpilepsyBraceletServiceGrpc.getSendEmergencyAlertMethod) == null) {
      synchronized (EpilepsyBraceletServiceGrpc.class) {
        if ((getSendEmergencyAlertMethod = EpilepsyBraceletServiceGrpc.getSendEmergencyAlertMethod) == null) {
          EpilepsyBraceletServiceGrpc.getSendEmergencyAlertMethod = getSendEmergencyAlertMethod = 
              io.grpc.MethodDescriptor.<generated.epilepsybracelet.EmergencyAlertRequest, generated.epilepsybracelet.EmergencyAlertAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "epilepsybracelet.EpilepsyBraceletService", "SendEmergencyAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.epilepsybracelet.EmergencyAlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.epilepsybracelet.EmergencyAlertAck.getDefaultInstance()))
                  .setSchemaDescriptor(new EpilepsyBraceletServiceMethodDescriptorSupplier("SendEmergencyAlert"))
                  .build();
          }
        }
     }
     return getSendEmergencyAlertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EpilepsyBraceletServiceStub newStub(io.grpc.Channel channel) {
    return new EpilepsyBraceletServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EpilepsyBraceletServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EpilepsyBraceletServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EpilepsyBraceletServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EpilepsyBraceletServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EpilepsyBraceletServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Bidirectional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.epilepsybracelet.BiometricData> streamBiometricData(
        io.grpc.stub.StreamObserver<generated.epilepsybracelet.SeizureAlert> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamBiometricDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void sendEmergencyAlert(generated.epilepsybracelet.EmergencyAlertRequest request,
        io.grpc.stub.StreamObserver<generated.epilepsybracelet.EmergencyAlertAck> responseObserver) {
      asyncUnimplementedUnaryCall(getSendEmergencyAlertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamBiometricDataMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                generated.epilepsybracelet.BiometricData,
                generated.epilepsybracelet.SeizureAlert>(
                  this, METHODID_STREAM_BIOMETRIC_DATA)))
          .addMethod(
            getSendEmergencyAlertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.epilepsybracelet.EmergencyAlertRequest,
                generated.epilepsybracelet.EmergencyAlertAck>(
                  this, METHODID_SEND_EMERGENCY_ALERT)))
          .build();
    }
  }

  /**
   */
  public static final class EpilepsyBraceletServiceStub extends io.grpc.stub.AbstractStub<EpilepsyBraceletServiceStub> {
    private EpilepsyBraceletServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EpilepsyBraceletServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EpilepsyBraceletServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EpilepsyBraceletServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bidirectional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.epilepsybracelet.BiometricData> streamBiometricData(
        io.grpc.stub.StreamObserver<generated.epilepsybracelet.SeizureAlert> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamBiometricDataMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void sendEmergencyAlert(generated.epilepsybracelet.EmergencyAlertRequest request,
        io.grpc.stub.StreamObserver<generated.epilepsybracelet.EmergencyAlertAck> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendEmergencyAlertMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EpilepsyBraceletServiceBlockingStub extends io.grpc.stub.AbstractStub<EpilepsyBraceletServiceBlockingStub> {
    private EpilepsyBraceletServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EpilepsyBraceletServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EpilepsyBraceletServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EpilepsyBraceletServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public generated.epilepsybracelet.EmergencyAlertAck sendEmergencyAlert(generated.epilepsybracelet.EmergencyAlertRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendEmergencyAlertMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EpilepsyBraceletServiceFutureStub extends io.grpc.stub.AbstractStub<EpilepsyBraceletServiceFutureStub> {
    private EpilepsyBraceletServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EpilepsyBraceletServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EpilepsyBraceletServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EpilepsyBraceletServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.epilepsybracelet.EmergencyAlertAck> sendEmergencyAlert(
        generated.epilepsybracelet.EmergencyAlertRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendEmergencyAlertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_EMERGENCY_ALERT = 0;
  private static final int METHODID_STREAM_BIOMETRIC_DATA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EpilepsyBraceletServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EpilepsyBraceletServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_EMERGENCY_ALERT:
          serviceImpl.sendEmergencyAlert((generated.epilepsybracelet.EmergencyAlertRequest) request,
              (io.grpc.stub.StreamObserver<generated.epilepsybracelet.EmergencyAlertAck>) responseObserver);
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
        case METHODID_STREAM_BIOMETRIC_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamBiometricData(
              (io.grpc.stub.StreamObserver<generated.epilepsybracelet.SeizureAlert>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EpilepsyBraceletServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EpilepsyBraceletServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.epilepsybracelet.EpilepsyBraceletProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EpilepsyBraceletService");
    }
  }

  private static final class EpilepsyBraceletServiceFileDescriptorSupplier
      extends EpilepsyBraceletServiceBaseDescriptorSupplier {
    EpilepsyBraceletServiceFileDescriptorSupplier() {}
  }

  private static final class EpilepsyBraceletServiceMethodDescriptorSupplier
      extends EpilepsyBraceletServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EpilepsyBraceletServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EpilepsyBraceletServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EpilepsyBraceletServiceFileDescriptorSupplier())
              .addMethod(getStreamBiometricDataMethod())
              .addMethod(getSendEmergencyAlertMethod())
              .build();
        }
      }
    }
    return result;
  }
}
