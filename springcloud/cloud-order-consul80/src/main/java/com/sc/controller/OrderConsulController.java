package com.sc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderConsulController {

    public static final String PAY_URL = "http://cloud-pay-consul";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/consul")
    public String payInfo(){
        return restTemplate.getForObject(PAY_URL + "/pay/consul", String.class);
    }
}
