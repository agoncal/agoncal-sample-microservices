package org.agoncal.sample.microservices.hystrix.stockbroker.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class HoldingsServiceController {

    private final NonHystrixDelegate nonHystrix;
    private final HystrixDelegate hystrix;

    @RequestMapping(value = "/getHoldings/{customer}", method = RequestMethod.GET)
    public List<Holding> getHoldings(@PathVariable String customer) throws Exception {

        List<Holding> holdings = getHoldings();
        holdings.stream().forEach(h -> {
            try {
                h.setPrice(nonHystrix.getLatestPrice(h.getTicker()));
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
        return holdings;
    }

    private List<Holding> getHoldings() {
        return Arrays.asList(new Holding("IBM", 100.0));
    }
}