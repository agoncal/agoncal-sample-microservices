package org.agoncal.sample.microservice.wildflyswarm;

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
@Path("/s1")
@Produces(MediaType.TEXT_PLAIN)
public class ServiceOneEndpoint {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final String QUOTE = "Three Rings for the Elven-kings under the sky, ";

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    public Response quote() {
        return Response.ok(QUOTE).build();
    }
}
