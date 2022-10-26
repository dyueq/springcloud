package com.sc.service;

import org.springframework.stereotype.Component;

@Component
public class OrderHystrixFallback implements OrderHystrixService{

    @Override
    public String payInfo_OK(Integer id) {
        return "Fallback Service fallback payInfo_OK";
    }

    @Override
    public String payInfo_TimeOut(Integer id) {
        return "Fallback Service fallback payInfo_TimeOut";
    }
}
