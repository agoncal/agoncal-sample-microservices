package org.agoncal.sample.microservice.consul;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.File;
import java.net.URI;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static org.agoncal.sample.microservice.consul.QuoteFourEndpoint.QUOTE;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@RunAsClient
public class QuoteFourEndpointTest {

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

        File[] commons = Maven.resolver().resolve("org.agoncal.sample.microservice.consul:commons:1.0").withTransitivity().asFile();

        return ShrinkWrap.create(WebArchive.class)
            .addClasses(QuoteFourEndpoint.class, Application.class)
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsLibraries(commons);
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void shouldCheckQuote() throws Exception {
        Response response = ClientBuilder.newClient().target(baseURL).path("/quotes").request(TEXT_PLAIN).get();
        assertEquals(200, response.getStatus());
        assertEquals(QUOTE, response.readEntity(String.class));
    }
}
