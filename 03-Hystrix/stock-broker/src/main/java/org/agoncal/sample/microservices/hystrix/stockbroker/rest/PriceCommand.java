package org.agoncal.sample.microservices.hystrix.stockbroker.rest;

import com.netflix.hystrix.HystrixCommand;
import org.agoncal.sample.microservices.hystrix.stockbroker.service.TickerPriceRetrieverService;
import org.springframework.web.client.RestTemplate;

class PriceCommand extends HystrixCommand<Double> {

    private final TickerPriceRetrieverService priceDelegate;
    private final String ticker;
    private final RestTemplate restTemplate;

    public PriceCommand(TickerPriceRetrieverService priceDelegate,
                        String ticker, RestTemplate restTemplate,
                        HystrixCommand.Setter config) {
        super(config);
        this.priceDelegate = priceDelegate;
        this.ticker = ticker;
        this.restTemplate = restTemplate;
    }

    @Override
    public Double run() throws Exception {
        return priceDelegate.getLatestPrice(ticker, restTemplate);
    }

    @Override
    public Double getFallback() {
        return 99.999;
    }
}