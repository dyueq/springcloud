package com.sc.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sc.service.PayService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PayServiceImpl implements PayService {

    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    @Override
    public String payInfo_OK(Integer id) {
        return "线程池 " + Thread.currentThread().getName() + " payInfo_OK , id: " + id + "\t" + "╰(*°▽°*)╯";
    }

    @Override
    @HystrixCommand(fallbackMethod = "payInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String payInfo_TimeOut(Integer id) {
        int time = 3;
//        int s = 10/0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 " + Thread.currentThread().getName() + " payInfo_TimeOut , id: " + id + "\t" + "╰(*°▽°*)╯,耗时" + time + "s";
    }

    public String payInfo_TimeOutHandler(Integer id){
        return "线程池 " + Thread.currentThread().getName() + " 系统繁忙或运行报错，请稍后再试 , id: " + id + "\t" + "(┬┬﹏┬┬)";
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "payCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后断路
    })
    public String payCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }
    public String payCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，id：" + id;
    }
}
