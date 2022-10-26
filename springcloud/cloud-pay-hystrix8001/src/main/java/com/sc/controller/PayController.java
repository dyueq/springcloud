package com.sc.controller;

import com.sc.service.impl.PayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PayController {
    @Autowired
    private PayServiceImpl payService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/pay/hystrix/ok/{id}")
    public String payInfo_OK(@PathVariable("id") Integer id){
        return payService.payInfo_OK(id);
    }

    @GetMapping("/pay/hystrix/timeout/{id}")
    public String payInfo_TimeOut(@PathVariable("id") Integer id){
        return payService.payInfo_TimeOut(id);
    }

    //服务熔断
    @GetMapping("/pay/circuit/{id}")
    public String payCircuitBreaker(@PathVariable("id") Integer id){
        return payService.payCircuitBreaker(id);
    }
}
