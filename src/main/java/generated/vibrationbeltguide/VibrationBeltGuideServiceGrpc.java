package generated.vibrationbeltguide;

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
    comments = "Source: vibrationbeltguide.proto")
public final class VibrationBeltGuideServiceGrpc {

  private VibrationBeltGuideServiceGrpc() {}

  public static final String SERVICE_NAME = "vibrationbeltguide.VibrationBeltGuideService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.vibrationbeltguide.DestinationRequest,
      generated.vibrationbeltguide.DestinationAck> getRequestDestinationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestDestination",
      requestType = generated.vibrationbeltguide.DestinationRequest.class,
      responseType = generated.vibrationbeltguide.DestinationAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.vibrationbeltguide.DestinationRequest,
      generated.vibrationbeltguide.DestinationAck> getRequestDestinationMethod() {
    io.grpc.MethodDescriptor<generated.vibrationbeltguide.DestinationRequest, generated.vibrationbeltguide.DestinationAck> getRequestDestinationMethod;
    if ((getRequestDestinationMethod = VibrationBeltGuideServiceGrpc.getRequestDestinationMethod) == null) {
      synchronized (VibrationBeltGuideServiceGrpc.class) {
        if ((getRequestDestinationMethod = VibrationBeltGuideServiceGrpc.getRequestDestinationMethod) == null) {
          VibrationBeltGuideServiceGrpc.getRequestDestinationMethod = getRequestDestinationMethod = 
              io.grpc.MethodDescriptor.<generated.vibrationbeltguide.DestinationRequest, generated.vibrationbeltguide.DestinationAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "vibrationbeltguide.VibrationBeltGuideService", "RequestDestination"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.vibrationbeltguide.DestinationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.vibrationbeltguide.DestinationAck.getDefaultInstance()))
                  .setSchemaDescriptor(new VibrationBeltGuideServiceMethodDescriptorSupplier("RequestDestination"))
                  .build();
          }
        }
     }
     return getRequestDestinationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.vibrationbeltguide.NavigationRequest,
      generated.vibrationbeltguide.VibrationCommand> getStreamNavigationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamNavigation",
      requestType = generated.vibrationbeltguide.NavigationRequest.class,
      responseType = generated.vibrationbeltguide.VibrationCommand.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.vibrationbeltguide.NavigationRequest,
      generated.vibrationbeltguide.VibrationCommand> getStreamNavigationMethod() {
    io.grpc.MethodDescriptor<generated.vibrationbeltguide.NavigationRequest, generated.vibrationbeltguide.VibrationCommand> getStreamNavigationMethod;
    if ((getStreamNavigationMethod = VibrationBeltGuideServiceGrpc.getStreamNavigationMethod) == null) {
      synchronized (VibrationBeltGuideServiceGrpc.class) {
        if ((getStreamNavigationMethod = VibrationBeltGuideServiceGrpc.getStreamNavigationMethod) == null) {
          VibrationBeltGuideServiceGrpc.getStreamNavigationMethod = getStreamNavigationMethod = 
              io.grpc.MethodDescriptor.<generated.vibrationbeltguide.NavigationRequest, generated.vibrationbeltguide.VibrationCommand>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "vibrationbeltguide.VibrationBeltGuideService", "StreamNavigation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.vibrationbeltguide.NavigationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.vibrationbeltguide.VibrationCommand.getDefaultInstance()))
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
     * <pre>
     * Unary
     * </pre>
     */
    public void requestDestination(generated.vibrationbeltguide.DestinationRequest request,
        io.grpc.stub.StreamObserver<generated.vibrationbeltguide.DestinationAck> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestDestinationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming
     * </pre>
     */
    public void streamNavigation(generated.vibrationbeltguide.NavigationRequest request,
        io.grpc.stub.StreamObserver<generated.vibrationbeltguide.VibrationCommand> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamNavigationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestDestinationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.vibrationbeltguide.DestinationRequest,
                generated.vibrationbeltguide.DestinationAck>(
                  this, METHODID_REQUEST_DESTINATION)))
          .addMethod(
            getStreamNavigationMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                generated.vibrationbeltguide.NavigationRequest,
                generated.vibrationbeltguide.VibrationCommand>(
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
     * <pre>
     * Unary
     * </pre>
     */
    public void requestDestination(generated.vibrationbeltguide.DestinationRequest request,
        io.grpc.stub.StreamObserver<generated.vibrationbeltguide.DestinationAck> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRequestDestinationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming
     * </pre>
     */
    public void streamNavigation(generated.vibrationbeltguide.NavigationRequest request,
        io.grpc.stub.StreamObserver<generated.vibrationbeltguide.VibrationCommand> responseObserver) {
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
     * <pre>
     * Unary
     * </pre>
     */
    public generated.vibrationbeltguide.DestinationAck requestDestination(generated.vibrationbeltguide.DestinationRequest request) {
      return blockingUnaryCall(
          getChannel(), getRequestDestinationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server-side streaming
     * </pre>
     */
    public java.util.Iterator<generated.vibrationbeltguide.VibrationCommand> streamNavigation(
        generated.vibrationbeltguide.NavigationRequest request) {
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
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.vibrationbeltguide.DestinationAck> requestDestination(
        generated.vibrationbeltguide.DestinationRequest request) {
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
          serviceImpl.requestDestination((generated.vibrationbeltguide.DestinationRequest) request,
              (io.grpc.stub.StreamObserver<generated.vibrationbeltguide.DestinationAck>) responseObserver);
          break;
        case METHODID_STREAM_NAVIGATION:
          serviceImpl.streamNavigation((generated.vibrationbeltguide.NavigationRequest) request,
              (io.grpc.stub.StreamObserver<generated.vibrationbeltguide.VibrationCommand>) responseObserver);
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
      return generated.vibrationbeltguide.VibrationBeltGuideProto.getDescriptor();
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
