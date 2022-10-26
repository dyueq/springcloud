package com.sc.controller;

import com.sc.bean.Result;
import com.sc.service.PayOpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderOpenFeignController {

    @Autowired
    private PayOpenFeignService feignService;

    @GetMapping("/consumer/openfeign/getPayById/{id}")
    public Result getPayById(@PathVariable Long id){
        return feignService.getPayById(id);
    }
}
