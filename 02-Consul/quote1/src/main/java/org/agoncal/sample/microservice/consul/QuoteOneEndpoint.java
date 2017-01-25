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
@Advertise("quote1")
@Path("/quotes")
@Produces(MediaType.TEXT_PLAIN)
@Auditable
public class QuoteOneEndpoint {

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

    public static final String QUOTE = "Three Rings for the Elven-kings under the sky, ";

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

        // Invoke Quote 2
        URI nextQuoteURI = consulRegistry.discoverServiceURI("quote2");
        String nextQuote = ClientBuilder.newClient().target(nextQuoteURI).path("quotes/chain").request(TEXT_PLAIN).get(String.class);

        return Response.ok(QUOTE + nextQuote).build();
    }

    @GET
    @Path("/aggregate")
    public Response aggregateAllQuotes() {

        // Invoke Quote 2
        URI quote2URI = consulRegistry.discoverServiceURI("quote2");
        String quote2 = ClientBuilder.newClient().target(quote2URI).path("quotes").request(TEXT_PLAIN).get(String.class);
        // Invoke Quote 3
        URI quote3URI = consulRegistry.discoverServiceURI("quote3");
        String quote3 = ClientBuilder.newClient().target(quote3URI).path("quotes").request(TEXT_PLAIN).get(String.class);
        // Invoke Quote 4
        URI quote4URI = consulRegistry.discoverServiceURI("quote4");
        String quote4 = ClientBuilder.newClient().target(quote4URI).path("quotes").request(TEXT_PLAIN).get(String.class);
        // Invoke Quote 5
        URI quote5URI = consulRegistry.discoverServiceURI("quote5");
        String quote5 = ClientBuilder.newClient().target(quote5URI).path("quotes").request(TEXT_PLAIN).get(String.class);
        // Invoke Quote 6
        URI quote6URI = consulRegistry.discoverServiceURI("quote6");
        String quote6 = ClientBuilder.newClient().target(quote6URI).path("quotes").request(TEXT_PLAIN).get(String.class);

        return Response.ok(QUOTE + quote2 + quote3 + quote4 + quote5 + quote6).build();
    }
}
