package org.agoncal.sample.microservice.consul;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.Service;

import java.net.URI;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ConsulRegistry {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final Logger LOG = Logger.getLogger(ConsulRegistry.class.getName());

    // ======================================
    // =          Business methods          =
    // ======================================

    public static URI discoverServiceURI(String name) {

        ConsulClient client = getConsulClient();
        Map<String, Service> agentServices = client.getAgentServices().getValue();

        Service match = null;

        for (Map.Entry<String, Service> entry : agentServices.entrySet()) {
            if (entry.getValue().getService().equals(name)) {
                match = entry.getValue();
                break;
            }
        }

        if (null == match)
            throw new RuntimeException("Service '" + name + "' cannot be found!");


        // ...
        try {
            LOG.info("#### Discovering service " + name + " at http://" + match.getAddress() + ":" + match.getPort());
            return new URI("http://" + match.getAddress() + ":" + match.getPort());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static ConsulClient getConsulClient() {
        String consulHost = System.getProperty("consul.host", "localhost");
        LOG.info(("#### Consul client on address : " + consulHost));
        ConsulClient client = new ConsulClient(consulHost);
        return client;
    }
}
