package com.sc.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BreakerController {
    public static final String PAY_URL = "http://nacos-pay-service";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    public String fallback(@PathVariable("id") Integer id){
        String result = restTemplate.getForObject(PAY_URL + "/paySQL/" + id, String.class, id);
        if (id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }
        return result;
    }
    //fallback
    public String handlerFallback(@PathVariable("id") Integer id,Throwable e){
        return "兜底handlerFallback，exception内容：" + e.getMessage() + "  id:" + id;
    }
    //blockHandler
    public String blockHandler(@PathVariable("id") Integer id, BlockException blockException){
        return "blockHandler-sentinel限流，blockException " + blockException.getMessage() + " id: " + id;
    }

    //-----------------openFeign
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/consumer/paySQL/{id}")
    public String paySQL(@PathVariable("id") Integer id){
        return orderService.paySQL(id);
    };

}
