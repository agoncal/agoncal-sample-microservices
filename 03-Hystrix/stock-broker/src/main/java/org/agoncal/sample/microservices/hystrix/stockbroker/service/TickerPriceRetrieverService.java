package org.agoncal.sample.microservices.hystrix.stockbroker.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TickerPriceRetrieverService {

    public Double getLatestPrice(String ticker, RestTemplate restTemplate) throws Exception {
        Double price = restTemplate.exchange(
                "http://localhost:8083/price/api/getTickerPrice/{ticker}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<Double>() {
                }
                , ticker).getBody();
        return price;
    }
}