package com.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class PayApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication8006.class,args);
    }
}
