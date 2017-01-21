package org.agoncal.sample.microservice.consul;

import org.wildfly.swarm.topology.Advertise;

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
@Advertise("quote1")
@Path("/quote")
@Produces(MediaType.TEXT_PLAIN)
public class S1Endpoint {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final String QUOTE = "Three Rings for the Elven-kings under the sky,";

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    public Response quote() {
        return Response.ok(QUOTE).build();
    }
}
