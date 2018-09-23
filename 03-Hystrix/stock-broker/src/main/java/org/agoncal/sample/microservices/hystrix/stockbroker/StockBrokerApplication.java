package org.agoncal.sample.microservices.hystrix.stockbroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockBrokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockBrokerApplication.class, args);
    }
}
