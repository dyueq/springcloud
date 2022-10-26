package com.sc.controller;

import com.sc.bean.Pay;
import com.sc.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

//    public static final String PAY_URL = "http://localhost:8001";
    public static final String PAY_URL = "http://CLOUD-PAY-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    //新增
    @GetMapping("/consumer/create")
    public Result create(Pay pay){
        return restTemplate.postForObject(PAY_URL+"/create",pay,Result.class);
    }

    //查询
    @GetMapping("/consumer/getPayById/{id}")
    public Result getPayById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAY_URL+"/getPayById/"+id,Result.class);
    }

    //entity
    @GetMapping("/consumer/getForEntity/getPayById/{id}")
    public Result getPayById2(@PathVariable("id") Long id){
        ResponseEntity<Result> entity = restTemplate.getForEntity(PAY_URL + "/getPayById/" + id, Result.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new Result(444,"操作失败");
        }
    }

    @GetMapping("/consumer/getForEntity/create")
    public Result create2(Pay pay){
        ResponseEntity<Result> entity = restTemplate.postForEntity(PAY_URL + "/create", pay, Result.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new Result(444,"操作失败");
        }
    }
}
