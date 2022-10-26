package com.sc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sc.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_Fallback")
public class OrderHystrixController {

    @Autowired
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/pay/hystrix/ok/{id}")
    String payInfo_OK(@PathVariable("id") Integer id){
        return orderHystrixService.payInfo_OK(id);
    };

    @GetMapping("/consumer/pay/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "payInfo_TimeOutFallBack",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//    })
    @HystrixCommand
    String payInfo_TimeOut(@PathVariable("id") Integer id){
//        int age = 1/0;
        return orderHystrixService.payInfo_TimeOut(id);
    }

    public String payInfo_TimeOutFallBack(@PathVariable("id") Integer id){
        return "我是消费者80端口，对方支付系统繁忙或运行出错，请稍后再试";
    }

    //下面是全局fallback方法
    public String global_Fallback(){
        return "全局异常信息，请稍后再试";
    }

}
