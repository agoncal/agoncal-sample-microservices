package org.agoncal.sample.microservices.hystrix.stockbroker.rest;

import org.agoncal.sample.microservices.hystrix.stockbroker.domain.Holding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HoldingsResource {

    private final Logger LOGGER = LoggerFactory.getLogger(HoldingsResource.class);

    private final NonHystrixDelegate nonHystrix;
//    private final HystrixDelegate hystrix;


    public HoldingsResource(NonHystrixDelegate nonHystrix) {
        this.nonHystrix = nonHystrix;
    }

    @GetMapping("/getHoldings/{customer}")
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

    @GetMapping("/getHoldings/health")
    public ResponseEntity<Void> health() {
        LOGGER.info("Alive and Kicking !!!");
        return ResponseEntity.ok().build();
    }
}