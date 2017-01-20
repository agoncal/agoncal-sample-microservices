package org.agoncal.sample.microservice.consul;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.net.URI;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@RunAsClient
public class S2EndpointTest {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @ArquillianResource
    private URI baseURL;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment(testable = false)
    public static WebArchive createDeployment() {

        return ShrinkWrap.create(WebArchive.class)
                .addClasses(S2Endpoint.class, Application.class);
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void shouldCheckQuote() throws Exception {
        Response response = ClientBuilder.newClient().target(baseURL).path("/quote").request(TEXT_PLAIN).get();
        assertEquals(200, response.getStatus());
        assertEquals("Seven for the Dwarf-lords in their halls of stone,", response.readEntity(String.class));
    }
}
