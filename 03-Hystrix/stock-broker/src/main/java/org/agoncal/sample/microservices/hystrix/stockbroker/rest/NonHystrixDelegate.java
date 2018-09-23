package org.agoncal.sample.microservices.hystrix.stockbroker.rest;

import org.agoncal.sample.microservices.hystrix.stockbroker.service.TickerPriceRetrieverService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NonHystrixDelegate implements PriceDelegate {

    private TickerPriceRetrieverService priceService;
    private final RestTemplate restTemplate;

    public NonHystrixDelegate(TickerPriceRetrieverService priceService) {
        this.priceService = priceService;
        restTemplate = new RestTemplate();
    }

    @Override
    public Double getLatestPrice(String ticker) throws Exception {
        return priceService.getLatestPrice(ticker, restTemplate);
    }
}
