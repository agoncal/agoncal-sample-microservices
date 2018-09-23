package org.agoncal.sample.microservices.hystrix.hystrixmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixMonitorApplication.class, args);
    }
}
