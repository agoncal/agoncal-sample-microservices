package org.agoncal.sample.microservices.hystrix.stockprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockPriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockPriceApplication.class, args);
    }
}
