package com.sc.service;

import org.springframework.stereotype.Component;

@Component
public class OrderFallbackService implements OrderService{
    @Override
    public String paySQL(Integer id) {
        return "服务降级返回，OrderFallbackService,id: " + id;
    }
}
