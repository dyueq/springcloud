package com.sc.service;

import com.sc.bean.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAY-SERVICE")
public interface PayOpenFeignService {
    @GetMapping ("/getPayById/{id}")
    public Result getPayById(@PathVariable("id") Long id);
}
