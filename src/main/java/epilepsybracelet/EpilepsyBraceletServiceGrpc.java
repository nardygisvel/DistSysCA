package epilepsybracelet;

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
    comments = "Source: proto.proto")
public final class EpilepsyBraceletServiceGrpc {

  private EpilepsyBraceletServiceGrpc() {}

  public static final String SERVICE_NAME = "epilepsybracelet.EpilepsyBraceletService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<epilepsybracelet.Proto.BiometricData,
      epilepsybracelet.Proto.SeizureResponse> getMonitorBiometricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorBiometrics",
      requestType = epilepsybracelet.Proto.BiometricData.class,
      responseType = epilepsybracelet.Proto.SeizureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<epilepsybracelet.Proto.BiometricData,
      epilepsybracelet.Proto.SeizureResponse> getMonitorBiometricsMethod() {
    io.grpc.MethodDescriptor<epilepsybracelet.Proto.BiometricData, epilepsybracelet.Proto.SeizureResponse> getMonitorBiometricsMethod;
    if ((getMonitorBiometricsMethod = EpilepsyBraceletServiceGrpc.getMonitorBiometricsMethod) == null) {
      synchronized (EpilepsyBraceletServiceGrpc.class) {
        if ((getMonitorBiometricsMethod = EpilepsyBraceletServiceGrpc.getMonitorBiometricsMethod) == null) {
          EpilepsyBraceletServiceGrpc.getMonitorBiometricsMethod = getMonitorBiometricsMethod = 
              io.grpc.MethodDescriptor.<epilepsybracelet.Proto.BiometricData, epilepsybracelet.Proto.SeizureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "epilepsybracelet.EpilepsyBraceletService", "MonitorBiometrics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  epilepsybracelet.Proto.BiometricData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  epilepsybracelet.Proto.SeizureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EpilepsyBraceletServiceMethodDescriptorSupplier("MonitorBiometrics"))
                  .build();
          }
        }
     }
     return getMonitorBiometricsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<epilepsybracelet.Proto.EmergencyRequest,
      epilepsybracelet.Proto.EmergencyAck> getEmergencyAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmergencyAlert",
      requestType = epilepsybracelet.Proto.EmergencyRequest.class,
      responseType = epilepsybracelet.Proto.EmergencyAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<epilepsybracelet.Proto.EmergencyRequest,
      epilepsybracelet.Proto.EmergencyAck> getEmergencyAlertMethod() {
    io.grpc.MethodDescriptor<epilepsybracelet.Proto.EmergencyRequest, epilepsybracelet.Proto.EmergencyAck> getEmergencyAlertMethod;
    if ((getEmergencyAlertMethod = EpilepsyBraceletServiceGrpc.getEmergencyAlertMethod) == null) {
      synchronized (EpilepsyBraceletServiceGrpc.class) {
        if ((getEmergencyAlertMethod = EpilepsyBraceletServiceGrpc.getEmergencyAlertMethod) == null) {
          EpilepsyBraceletServiceGrpc.getEmergencyAlertMethod = getEmergencyAlertMethod = 
              io.grpc.MethodDescriptor.<epilepsybracelet.Proto.EmergencyRequest, epilepsybracelet.Proto.EmergencyAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "epilepsybracelet.EpilepsyBraceletService", "EmergencyAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  epilepsybracelet.Proto.EmergencyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  epilepsybracelet.Proto.EmergencyAck.getDefaultInstance()))
                  .setSchemaDescriptor(new EpilepsyBraceletServiceMethodDescriptorSupplier("EmergencyAlert"))
                  .build();
          }
        }
     }
     return getEmergencyAlertMethod;
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
     */
    public io.grpc.stub.StreamObserver<epilepsybracelet.Proto.BiometricData> monitorBiometrics(
        io.grpc.stub.StreamObserver<epilepsybracelet.Proto.SeizureResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getMonitorBiometricsMethod(), responseObserver);
    }

    /**
     */
    public void emergencyAlert(epilepsybracelet.Proto.EmergencyRequest request,
        io.grpc.stub.StreamObserver<epilepsybracelet.Proto.EmergencyAck> responseObserver) {
      asyncUnimplementedUnaryCall(getEmergencyAlertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMonitorBiometricsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                epilepsybracelet.Proto.BiometricData,
                epilepsybracelet.Proto.SeizureResponse>(
                  this, METHODID_MONITOR_BIOMETRICS)))
          .addMethod(
            getEmergencyAlertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                epilepsybracelet.Proto.EmergencyRequest,
                epilepsybracelet.Proto.EmergencyAck>(
                  this, METHODID_EMERGENCY_ALERT)))
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
     */
    public io.grpc.stub.StreamObserver<epilepsybracelet.Proto.BiometricData> monitorBiometrics(
        io.grpc.stub.StreamObserver<epilepsybracelet.Proto.SeizureResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getMonitorBiometricsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void emergencyAlert(epilepsybracelet.Proto.EmergencyRequest request,
        io.grpc.stub.StreamObserver<epilepsybracelet.Proto.EmergencyAck> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEmergencyAlertMethod(), getCallOptions()), request, responseObserver);
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
     */
    public epilepsybracelet.Proto.EmergencyAck emergencyAlert(epilepsybracelet.Proto.EmergencyRequest request) {
      return blockingUnaryCall(
          getChannel(), getEmergencyAlertMethod(), getCallOptions(), request);
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
     */
    public com.google.common.util.concurrent.ListenableFuture<epilepsybracelet.Proto.EmergencyAck> emergencyAlert(
        epilepsybracelet.Proto.EmergencyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEmergencyAlertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EMERGENCY_ALERT = 0;
  private static final int METHODID_MONITOR_BIOMETRICS = 1;

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
        case METHODID_EMERGENCY_ALERT:
          serviceImpl.emergencyAlert((epilepsybracelet.Proto.EmergencyRequest) request,
              (io.grpc.stub.StreamObserver<epilepsybracelet.Proto.EmergencyAck>) responseObserver);
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
        case METHODID_MONITOR_BIOMETRICS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorBiometrics(
              (io.grpc.stub.StreamObserver<epilepsybracelet.Proto.SeizureResponse>) responseObserver);
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
      return epilepsybracelet.Proto.getDescriptor();
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
              .addMethod(getMonitorBiometricsMethod())
              .addMethod(getEmergencyAlertMethod())
              .build();
        }
      }
    }
    return result;
  }
}
