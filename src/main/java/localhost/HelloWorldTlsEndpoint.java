package localhost;

import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;
import proto.GrpcRequest;
import proto.ServiceGrpc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class
HelloWorldTlsEndpoint {

    @GrpcClient("hello")
    ServiceGrpc.ServiceBlockingStub blockingHelloService;

    @GET
    @Path("/blocking/{name}")
    public String helloBlocking(@PathParam("name") String name) {
        return blockingHelloService.grpc(GrpcRequest.newBuilder().setFirstName(name).build()).getGreeting();
    }
}
