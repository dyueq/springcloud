package com.sc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-pay-service",fallback = OrderFallbackService.class)
public interface OrderService {
    @GetMapping(value = "paySQL/{id}")
    public String paySQL(@PathVariable("id") Integer id);
}
