package org.agoncal.sample.microservice.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/microRestEndpoint")
public class MicroRestEndpoint {

    @GET
    @Produces("text/plain")
    public Response doGet() {
        return Response.ok("Method GET Invoked").build();
    }
}