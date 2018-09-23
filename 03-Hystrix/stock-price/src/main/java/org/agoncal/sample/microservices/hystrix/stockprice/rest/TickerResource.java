package org.agoncal.sample.microservices.hystrix.stockprice.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TickerResource {

    private final Logger LOGGER = LoggerFactory.getLogger(TickerResource.class);

    private long outOfServiceRate = 10;
    private long stdDevProcessingTimeInMillis = 20;
    private long meanProcessingTimeInMillis = 20;


    @GetMapping("/getTickerPrice/{ticker}")
    public Double getTickerPrice(@PathVariable String ticker) {
        Random r = new Random();
        long processingTime = (long) (r.nextGaussian() * stdDevProcessingTimeInMillis + meanProcessingTimeInMillis);
        LOGGER.info("Processing Time: {0}", processingTime);
        try {
            Thread.sleep(processingTime);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
        }
        if (r.nextDouble() < (outOfServiceRate / 100.0)) {
            throw new RuntimeException("Service not available");
        }
        return getTickerPriceFromExchanges(ticker);
    }

    private Double getTickerPriceFromExchanges(String ticker) {
        return new Random().nextDouble();
    }

    @GetMapping("/getTickerPrice/health")
    public ResponseEntity<Void> health() {
        LOGGER.info("Alive and Kicking !!!");
        return ResponseEntity.ok().build();
    }
}
