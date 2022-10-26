package com.sc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//把每一个方法的服务降级写到另一个类，并实现该接口
@FeignClient(value = "CLOUD-PAY-HYSTRIX",fallback = OrderHystrixFallback.class)
public interface OrderHystrixService {

    @GetMapping("/pay/hystrix/ok/{id}")
    String payInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/pay/hystrix/timeout/{id}")
    String payInfo_TimeOut(@PathVariable("id") Integer id);

}
