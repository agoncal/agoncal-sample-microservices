package org.agoncal.sample.microservice.consul;

import org.wildfly.swarm.topology.Advertise;

import javax.inject.Inject;
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
@Advertise("quote3")
@Path("/quotes")
@Produces(MediaType.TEXT_PLAIN)
@Auditable
public class QuoteThreeEndpoint {

    // ======================================
    // =         Injection Points           =
    // ======================================

    @Inject
    private ConsulRegistry consulRegistry;
    @Inject
    private Logger logger;

    // ======================================
    // =             Constants              =
    // ======================================

    public static final String QUOTE = "Nine for Mortal Men doomed to die, ";

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    public Response quote() {
        return Response.ok(QUOTE).build();
    }

    @GET
    @Path("/chain")
    public Response chainAllQuotes() {

        // Invoke Quote 4
        URI nextQuoteURI = consulRegistry.discoverServiceURI("quote4");
        String nextQuote  = ClientBuilder.newClient().target(nextQuoteURI).path("quotes/chain").request(TEXT_PLAIN).get(String.class);

        return Response.ok(QUOTE + nextQuote).build();
    }
}
