package com.sc.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sc.bean.Pay;
import com.sc.bean.Result;
import com.sc.handler.BlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowController {
    @GetMapping("/testA")
    public String testA(){
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "-----testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,@RequestParam(value = "p2",required = false) String p2){
        return "HotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "deal_testHotKey";
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "bySource",blockHandler = "handleException")
    public Result ByResource(){
        return new Result(200,"按资源名称限流测试",new Pay(20L,"serial01"));
    }
    public Result handleException(BlockException e){
        return new Result(404,e.getClass().getCanonicalName() + "服务不可用");
    }

    @GetMapping("/limit/blockHandler")
    @SentinelResource(value = "blockHandler",blockHandlerClass = BlockHandler.class,blockHandler = "handlerException2")
    public Result BlockHandler(){
        return new Result(200,"自定义",new Pay(20L,"serial03"));
    }






}
