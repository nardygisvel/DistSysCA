package generated.deviceregistry;

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
    comments = "Source: deviceregistry.proto")
public final class DeviceRegistryServiceGrpc {

  private DeviceRegistryServiceGrpc() {}

  public static final String SERVICE_NAME = "deviceregistry.DeviceRegistryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.deviceregistry.ListDevicesRequest,
      generated.deviceregistry.ListDevicesResponse> getListDevicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDevices",
      requestType = generated.deviceregistry.ListDevicesRequest.class,
      responseType = generated.deviceregistry.ListDevicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.deviceregistry.ListDevicesRequest,
      generated.deviceregistry.ListDevicesResponse> getListDevicesMethod() {
    io.grpc.MethodDescriptor<generated.deviceregistry.ListDevicesRequest, generated.deviceregistry.ListDevicesResponse> getListDevicesMethod;
    if ((getListDevicesMethod = DeviceRegistryServiceGrpc.getListDevicesMethod) == null) {
      synchronized (DeviceRegistryServiceGrpc.class) {
        if ((getListDevicesMethod = DeviceRegistryServiceGrpc.getListDevicesMethod) == null) {
          DeviceRegistryServiceGrpc.getListDevicesMethod = getListDevicesMethod = 
              io.grpc.MethodDescriptor.<generated.deviceregistry.ListDevicesRequest, generated.deviceregistry.ListDevicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "deviceregistry.DeviceRegistryService", "ListDevices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.deviceregistry.ListDevicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.deviceregistry.ListDevicesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceRegistryServiceMethodDescriptorSupplier("ListDevices"))
                  .build();
          }
        }
     }
     return getListDevicesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeviceRegistryServiceStub newStub(io.grpc.Channel channel) {
    return new DeviceRegistryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeviceRegistryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DeviceRegistryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeviceRegistryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DeviceRegistryServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DeviceRegistryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void listDevices(generated.deviceregistry.ListDevicesRequest request,
        io.grpc.stub.StreamObserver<generated.deviceregistry.ListDevicesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListDevicesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListDevicesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.deviceregistry.ListDevicesRequest,
                generated.deviceregistry.ListDevicesResponse>(
                  this, METHODID_LIST_DEVICES)))
          .build();
    }
  }

  /**
   */
  public static final class DeviceRegistryServiceStub extends io.grpc.stub.AbstractStub<DeviceRegistryServiceStub> {
    private DeviceRegistryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeviceRegistryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceRegistryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeviceRegistryServiceStub(channel, callOptions);
    }

    /**
     */
    public void listDevices(generated.deviceregistry.ListDevicesRequest request,
        io.grpc.stub.StreamObserver<generated.deviceregistry.ListDevicesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListDevicesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DeviceRegistryServiceBlockingStub extends io.grpc.stub.AbstractStub<DeviceRegistryServiceBlockingStub> {
    private DeviceRegistryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeviceRegistryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceRegistryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeviceRegistryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.deviceregistry.ListDevicesResponse listDevices(generated.deviceregistry.ListDevicesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListDevicesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DeviceRegistryServiceFutureStub extends io.grpc.stub.AbstractStub<DeviceRegistryServiceFutureStub> {
    private DeviceRegistryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeviceRegistryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceRegistryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeviceRegistryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.deviceregistry.ListDevicesResponse> listDevices(
        generated.deviceregistry.ListDevicesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListDevicesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DEVICES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DeviceRegistryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeviceRegistryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_DEVICES:
          serviceImpl.listDevices((generated.deviceregistry.ListDevicesRequest) request,
              (io.grpc.stub.StreamObserver<generated.deviceregistry.ListDevicesResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DeviceRegistryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeviceRegistryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.deviceregistry.DeviceRegistryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeviceRegistryService");
    }
  }

  private static final class DeviceRegistryServiceFileDescriptorSupplier
      extends DeviceRegistryServiceBaseDescriptorSupplier {
    DeviceRegistryServiceFileDescriptorSupplier() {}
  }

  private static final class DeviceRegistryServiceMethodDescriptorSupplier
      extends DeviceRegistryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeviceRegistryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeviceRegistryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeviceRegistryServiceFileDescriptorSupplier())
              .addMethod(getListDevicesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
