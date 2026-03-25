package vibrationbeltguide;

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
    comments = "Source: proto1.proto")
public final class VibrationBeltGuideServiceGrpc {

  private VibrationBeltGuideServiceGrpc() {}

  public static final String SERVICE_NAME = "vibrationbeltguide.VibrationBeltGuideService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<vibrationbeltguide.Proto1.DestinationRequest,
      vibrationbeltguide.Proto1.DestinationAck> getRequestDestinationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestDestination",
      requestType = vibrationbeltguide.Proto1.DestinationRequest.class,
      responseType = vibrationbeltguide.Proto1.DestinationAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<vibrationbeltguide.Proto1.DestinationRequest,
      vibrationbeltguide.Proto1.DestinationAck> getRequestDestinationMethod() {
    io.grpc.MethodDescriptor<vibrationbeltguide.Proto1.DestinationRequest, vibrationbeltguide.Proto1.DestinationAck> getRequestDestinationMethod;
    if ((getRequestDestinationMethod = VibrationBeltGuideServiceGrpc.getRequestDestinationMethod) == null) {
      synchronized (VibrationBeltGuideServiceGrpc.class) {
        if ((getRequestDestinationMethod = VibrationBeltGuideServiceGrpc.getRequestDestinationMethod) == null) {
          VibrationBeltGuideServiceGrpc.getRequestDestinationMethod = getRequestDestinationMethod = 
              io.grpc.MethodDescriptor.<vibrationbeltguide.Proto1.DestinationRequest, vibrationbeltguide.Proto1.DestinationAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vibrationbeltguide.VibrationBeltGuideService", "RequestDestination"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vibrationbeltguide.Proto1.DestinationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vibrationbeltguide.Proto1.DestinationAck.getDefaultInstance()))
                  .setSchemaDescriptor(new VibrationBeltGuideServiceMethodDescriptorSupplier("RequestDestination"))
                  .build();
          }
        }
     }
     return getRequestDestinationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<vibrationbeltguide.Proto1.DestinationRequest,
      vibrationbeltguide.Proto1.VibrationCommand> getStreamNavigationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamNavigation",
      requestType = vibrationbeltguide.Proto1.DestinationRequest.class,
      responseType = vibrationbeltguide.Proto1.VibrationCommand.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<vibrationbeltguide.Proto1.DestinationRequest,
      vibrationbeltguide.Proto1.VibrationCommand> getStreamNavigationMethod() {
    io.grpc.MethodDescriptor<vibrationbeltguide.Proto1.DestinationRequest, vibrationbeltguide.Proto1.VibrationCommand> getStreamNavigationMethod;
    if ((getStreamNavigationMethod = VibrationBeltGuideServiceGrpc.getStreamNavigationMethod) == null) {
      synchronized (VibrationBeltGuideServiceGrpc.class) {
        if ((getStreamNavigationMethod = VibrationBeltGuideServiceGrpc.getStreamNavigationMethod) == null) {
          VibrationBeltGuideServiceGrpc.getStreamNavigationMethod = getStreamNavigationMethod = 
              io.grpc.MethodDescriptor.<vibrationbeltguide.Proto1.DestinationRequest, vibrationbeltguide.Proto1.VibrationCommand>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "vibrationbeltguide.VibrationBeltGuideService", "StreamNavigation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vibrationbeltguide.Proto1.DestinationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  vibrationbeltguide.Proto1.VibrationCommand.getDefaultInstance()))
                  .setSchemaDescriptor(new VibrationBeltGuideServiceMethodDescriptorSupplier("StreamNavigation"))
                  .build();
          }
        }
     }
     return getStreamNavigationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VibrationBeltGuideServiceStub newStub(io.grpc.Channel channel) {
    return new VibrationBeltGuideServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VibrationBeltGuideServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VibrationBeltGuideServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VibrationBeltGuideServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VibrationBeltGuideServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class VibrationBeltGuideServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestDestination(vibrationbeltguide.Proto1.DestinationRequest request,
        io.grpc.stub.StreamObserver<vibrationbeltguide.Proto1.DestinationAck> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestDestinationMethod(), responseObserver);
    }

    /**
     */
    public void streamNavigation(vibrationbeltguide.Proto1.DestinationRequest request,
        io.grpc.stub.StreamObserver<vibrationbeltguide.Proto1.VibrationCommand> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamNavigationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestDestinationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                vibrationbeltguide.Proto1.DestinationRequest,
                vibrationbeltguide.Proto1.DestinationAck>(
                  this, METHODID_REQUEST_DESTINATION)))
          .addMethod(
            getStreamNavigationMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                vibrationbeltguide.Proto1.DestinationRequest,
                vibrationbeltguide.Proto1.VibrationCommand>(
                  this, METHODID_STREAM_NAVIGATION)))
          .build();
    }
  }

  /**
   */
  public static final class VibrationBeltGuideServiceStub extends io.grpc.stub.AbstractStub<VibrationBeltGuideServiceStub> {
    private VibrationBeltGuideServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VibrationBeltGuideServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VibrationBeltGuideServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VibrationBeltGuideServiceStub(channel, callOptions);
    }

    /**
     */
    public void requestDestination(vibrationbeltguide.Proto1.DestinationRequest request,
        io.grpc.stub.StreamObserver<vibrationbeltguide.Proto1.DestinationAck> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestDestinationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamNavigation(vibrationbeltguide.Proto1.DestinationRequest request,
        io.grpc.stub.StreamObserver<vibrationbeltguide.Proto1.VibrationCommand> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamNavigationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VibrationBeltGuideServiceBlockingStub extends io.grpc.stub.AbstractStub<VibrationBeltGuideServiceBlockingStub> {
    private VibrationBeltGuideServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VibrationBeltGuideServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VibrationBeltGuideServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VibrationBeltGuideServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public vibrationbeltguide.Proto1.DestinationAck requestDestination(vibrationbeltguide.Proto1.DestinationRequest request) {
      return blockingUnaryCall(
          getChannel(), getRequestDestinationMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<vibrationbeltguide.Proto1.VibrationCommand> streamNavigation(
        vibrationbeltguide.Proto1.DestinationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamNavigationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VibrationBeltGuideServiceFutureStub extends io.grpc.stub.AbstractStub<VibrationBeltGuideServiceFutureStub> {
    private VibrationBeltGuideServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VibrationBeltGuideServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VibrationBeltGuideServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VibrationBeltGuideServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<vibrationbeltguide.Proto1.DestinationAck> requestDestination(
        vibrationbeltguide.Proto1.DestinationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRequestDestinationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_DESTINATION = 0;
  private static final int METHODID_STREAM_NAVIGATION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VibrationBeltGuideServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VibrationBeltGuideServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_DESTINATION:
          serviceImpl.requestDestination((vibrationbeltguide.Proto1.DestinationRequest) request,
              (io.grpc.stub.StreamObserver<vibrationbeltguide.Proto1.DestinationAck>) responseObserver);
          break;
        case METHODID_STREAM_NAVIGATION:
          serviceImpl.streamNavigation((vibrationbeltguide.Proto1.DestinationRequest) request,
              (io.grpc.stub.StreamObserver<vibrationbeltguide.Proto1.VibrationCommand>) responseObserver);
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

  private static abstract class VibrationBeltGuideServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VibrationBeltGuideServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return vibrationbeltguide.Proto1.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VibrationBeltGuideService");
    }
  }

  private static final class VibrationBeltGuideServiceFileDescriptorSupplier
      extends VibrationBeltGuideServiceBaseDescriptorSupplier {
    VibrationBeltGuideServiceFileDescriptorSupplier() {}
  }

  private static final class VibrationBeltGuideServiceMethodDescriptorSupplier
      extends VibrationBeltGuideServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VibrationBeltGuideServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VibrationBeltGuideServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VibrationBeltGuideServiceFileDescriptorSupplier())
              .addMethod(getRequestDestinationMethod())
              .addMethod(getStreamNavigationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
