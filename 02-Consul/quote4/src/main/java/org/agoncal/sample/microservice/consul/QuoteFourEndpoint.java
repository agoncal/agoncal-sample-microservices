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
@Advertise("quote4")
@Path("/quotes")
@Produces(MediaType.TEXT_PLAIN)
public class QuoteFourEndpoint {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final String QUOTE = "One for the Dark Lord on his dark throne. ";

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    public Response quote() {
        return Response.ok(QUOTE).build();
    }
}
