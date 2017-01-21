package org.agoncal.sample.microservice.consul;

import org.wildfly.swarm.topology.Advertise;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Advertise("quote1")
@Path("/quotes")
@Produces(MediaType.TEXT_PLAIN)
public class QuoteOneEndpoint {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final Logger LOG = Logger.getLogger(QuoteOneEndpoint.class.getName());
    public static final String QUOTE = "Three Rings for the Elven-kings under the sky,";

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    public Response quote() {
        return Response.ok(QUOTE).build();
    }

    @GET
    @Path("/chain")
    public Response chainQuotes() {

        // Invoke Service 2
        URI chainURI = ConsulRegistry.discoverServiceURI("quote2");
        LOG.info("##### URI " + chainURI);
        String nextQuote  = ClientBuilder.newClient().target(chainURI).path("quote").request(TEXT_PLAIN).get(String.class);

        return Response.ok(QUOTE + nextQuote).build();
    }
}
