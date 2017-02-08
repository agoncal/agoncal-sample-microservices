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
@Path("/s2")
@Produces(MediaType.TEXT_PLAIN)
public class ServiceTwoEndpoint {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final String QUOTE = "Seven for the Dwarf-lords in their halls of stone, ";

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    public Response quote() {
        return Response.ok(QUOTE).build();
    }
}
