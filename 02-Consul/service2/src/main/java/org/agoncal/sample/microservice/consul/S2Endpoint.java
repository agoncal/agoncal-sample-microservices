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
@Advertise("quote2")
@Path("/quote")
@Produces(MediaType.TEXT_PLAIN)
public class S2Endpoint {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final String QUOTE = "Seven for the Dwarf-lords in their halls of stone,";

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    public Response quote() {
        return Response.ok(QUOTE).build();
    }
}
