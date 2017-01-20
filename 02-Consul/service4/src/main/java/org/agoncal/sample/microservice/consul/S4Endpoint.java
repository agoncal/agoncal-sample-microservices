package org.agoncal.sample.microservice.consul;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/quote")
public class S4Endpoint {

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response retrieve() {
        return Response.ok("One for the Dark Lord on his dark throne.").build();
    }
}
