package com.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PayApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication8002.class,args);
    }
}
