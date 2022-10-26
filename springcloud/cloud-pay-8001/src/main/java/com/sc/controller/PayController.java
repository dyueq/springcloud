package com.sc.controller;

import com.sc.bean.Pay;
import com.sc.bean.Result;
import com.sc.service.impl.PayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PayController {

    @Autowired
    private PayServiceImpl service;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/pay/lb")
    public String servePort(){
        return serverPort;
    }

    //添加
    @PostMapping("/create")
    public Result create(@RequestBody Pay pay){
        int i = service.create(pay);
        log.info("插入结果：" + i);
        return i > 0? new Result(200,"插入数据成功,serverPort:" + serverPort,i) : new Result(444,"插入数据失败",null);
    }
    //查询
    @GetMapping ("/getPayById/{id}")
    public Result getPayById(@PathVariable("id") Long id){
        Pay pay = service.getPayByID(id);
        log.info("插入结果：" + pay);
        return pay != null? new Result(200,"查询数据成功,serverPort:" + serverPort,pay) : new Result(444,"没有对应的记录,id:" + id,null);
    }

    //服务发现
    @GetMapping("/discovery")
    public Object discovery(){
        //服务
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            log.info(s);
        }
        //服务的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAY-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

}
