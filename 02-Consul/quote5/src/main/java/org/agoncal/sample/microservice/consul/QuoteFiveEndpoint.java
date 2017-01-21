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
@Advertise("quote5")
@Path("/quotes")
@Produces(MediaType.TEXT_PLAIN)
public class QuoteFiveEndpoint {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final String QUOTE = "One Ring to rule them all. One Ring to find them,";

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    public Response quote() {
        return Response.ok(QUOTE).build();
    }
}
