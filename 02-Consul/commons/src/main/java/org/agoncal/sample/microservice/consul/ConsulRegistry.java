package org.agoncal.sample.microservice.consul;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URI;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Auditable
@ApplicationScoped
public class ConsulRegistry {

    // ======================================
    // =             Constants              =
    // ======================================

    @Inject
    private Logger logger;

    // ======================================
    // =             Attributes             =
    // ======================================

    private ConsulClient consulClient;

    // ======================================
    // =          Business methods          =
    // ======================================

    public URI discoverServiceURI(String name) {

        if (consulClient == null)
        consulClient = getConsulClient();

        Map<String, Service> agentServices = consulClient.getAgentServices().getValue();

        Service match = null;

        for (Map.Entry<String, Service> entry : agentServices.entrySet()) {
            if (entry.getValue().getService().equals(name)) {
                match = entry.getValue();
                break;
            }
        }

        if (null == match)
            throw new RuntimeException("Service '" + name + "' cannot be found!");

        try {
            logger.info("#### Discovering service " + name + " at http://" + match.getAddress() + ":" + match.getPort());
            return new URI("http://" + match.getAddress() + ":" + match.getPort());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ConsulClient getConsulClient() {
        String consulHost = System.getProperty("consul.host", "localhost");
        logger.info(("#### Consul client on address : " + consulHost));
        ConsulClient client = new ConsulClient(consulHost);
        return client;
    }
}
