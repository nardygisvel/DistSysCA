package generated.belt;

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
public final class BeltServiceGrpc {

  private BeltServiceGrpc() {}

  public static final String SERVICE_NAME = "vibrationbeltguide.BeltService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.belt.NavRequest,
      generated.belt.NavInstruction> getGetNavigationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNavigation",
      requestType = generated.belt.NavRequest.class,
      responseType = generated.belt.NavInstruction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.belt.NavRequest,
      generated.belt.NavInstruction> getGetNavigationMethod() {
    io.grpc.MethodDescriptor<generated.belt.NavRequest, generated.belt.NavInstruction> getGetNavigationMethod;
    if ((getGetNavigationMethod = BeltServiceGrpc.getGetNavigationMethod) == null) {
      synchronized (BeltServiceGrpc.class) {
        if ((getGetNavigationMethod = BeltServiceGrpc.getGetNavigationMethod) == null) {
          BeltServiceGrpc.getGetNavigationMethod = getGetNavigationMethod = 
              io.grpc.MethodDescriptor.<generated.belt.NavRequest, generated.belt.NavInstruction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "vibrationbeltguide.BeltService", "GetNavigation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.belt.NavRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.belt.NavInstruction.getDefaultInstance()))
                  .setSchemaDescriptor(new BeltServiceMethodDescriptorSupplier("GetNavigation"))
                  .build();
          }
        }
     }
     return getGetNavigationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BeltServiceStub newStub(io.grpc.Channel channel) {
    return new BeltServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BeltServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BeltServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BeltServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BeltServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BeltServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * * SERVER-SIDE STREAMING
     * Client sends one 'NavRequest' (the destination).
     * Server stays open and sends many 'NavInstruction' messages 
     * (like a GPS: "Turn left", "Go straight", etc.).
     * </pre>
     */
    public void getNavigation(generated.belt.NavRequest request,
        io.grpc.stub.StreamObserver<generated.belt.NavInstruction> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNavigationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetNavigationMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                generated.belt.NavRequest,
                generated.belt.NavInstruction>(
                  this, METHODID_GET_NAVIGATION)))
          .build();
    }
  }

  /**
   */
  public static final class BeltServiceStub extends io.grpc.stub.AbstractStub<BeltServiceStub> {
    private BeltServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BeltServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BeltServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BeltServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * * SERVER-SIDE STREAMING
     * Client sends one 'NavRequest' (the destination).
     * Server stays open and sends many 'NavInstruction' messages 
     * (like a GPS: "Turn left", "Go straight", etc.).
     * </pre>
     */
    public void getNavigation(generated.belt.NavRequest request,
        io.grpc.stub.StreamObserver<generated.belt.NavInstruction> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetNavigationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BeltServiceBlockingStub extends io.grpc.stub.AbstractStub<BeltServiceBlockingStub> {
    private BeltServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BeltServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BeltServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BeltServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * * SERVER-SIDE STREAMING
     * Client sends one 'NavRequest' (the destination).
     * Server stays open and sends many 'NavInstruction' messages 
     * (like a GPS: "Turn left", "Go straight", etc.).
     * </pre>
     */
    public java.util.Iterator<generated.belt.NavInstruction> getNavigation(
        generated.belt.NavRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetNavigationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BeltServiceFutureStub extends io.grpc.stub.AbstractStub<BeltServiceFutureStub> {
    private BeltServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BeltServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BeltServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BeltServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_NAVIGATION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BeltServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BeltServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_NAVIGATION:
          serviceImpl.getNavigation((generated.belt.NavRequest) request,
              (io.grpc.stub.StreamObserver<generated.belt.NavInstruction>) responseObserver);
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

  private static abstract class BeltServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BeltServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.belt.Vibrationbeltguide.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BeltService");
    }
  }

  private static final class BeltServiceFileDescriptorSupplier
      extends BeltServiceBaseDescriptorSupplier {
    BeltServiceFileDescriptorSupplier() {}
  }

  private static final class BeltServiceMethodDescriptorSupplier
      extends BeltServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BeltServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BeltServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BeltServiceFileDescriptorSupplier())
              .addMethod(getGetNavigationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
