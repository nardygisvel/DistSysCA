/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.distsysca;

/**
 *
 * @author Nardy
 */
import io.grpc.*;

/**
 * A simple server interceptor that checks for a valid token in the metadata.
 * Every request must include a "token" header with the value "valid-token".
 * If the token is missing or wrong, the request is rejected.
 */
public class AuthInterceptor implements ServerInterceptor {

    // this is the key we look for in the metadata (like a header name)
    private static final Metadata.Key<String> TOKEN_KEY =
        Metadata.Key.of("token", Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {

        // get the token from the request headers
        String token = headers.get(TOKEN_KEY);

        // check if the token is valid
        if (token == null || !token.equals("valid-token")) {
            // reject the request - send back UNAUTHENTICATED error
            System.out.println("[Auth] Rejected request - bad or missing token");
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid or missing token"), new Metadata());
            return new ServerCall.Listener<ReqT>() {};  // empty listener, request stops here
        }

        // token is good, let the request through to the actual service
        System.out.println("[Auth] Token accepted");
        return next.startCall(call, headers);
    }
}
