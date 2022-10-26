package com.sc.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sc.bean.Pay;
import com.sc.bean.Result;
import org.springframework.stereotype.Component;

@Component
public class BlockHandler {
    public static Result handlerException1(BlockException exception){
        return new Result(444,"自定义-----1");
    }
    public static Result handlerException2(BlockException exception){
        return new Result(444,"自定义-----2");
    }
}
