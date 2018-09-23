package org.agoncal.sample.microservices.hystrix.stockbroker.rest;

public interface PriceDelegate {
    Double getLatestPrice(String ticker) throws Exception;
}