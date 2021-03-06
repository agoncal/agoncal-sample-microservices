package org.agoncal.sample.microservices.hystrix.stockbroker.rest;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import org.agoncal.sample.microservices.hystrix.stockbroker.service.TickerPriceRetrieverService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class HystrixDelegate implements PriceDelegate {

    private HystrixCommand.Setter config;
    private TickerPriceRetrieverService priceService;
    private final RestTemplate restTemplate;

    public HystrixDelegate(TickerPriceRetrieverService priceService) {
        this.priceService = priceService;
        restTemplate = new RestTemplate();
        config = HystrixCommand
                .Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("PriceCommand"));
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
        commandProperties.withExecutionIsolationThreadTimeoutInMilliseconds(1200);
        config.andCommandPropertiesDefaults(commandProperties);
        config.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                .withMaxQueueSize(-1)
                .withCoreSize(15));
    }

    @Override
    public Double getLatestPrice(String ticker) throws Exception {
        PriceCommand pc = new PriceCommand(priceService, ticker, restTemplate, config);
        Future<Double> pcFuture = pc.queue();
        return pcFuture.get();
    }
}