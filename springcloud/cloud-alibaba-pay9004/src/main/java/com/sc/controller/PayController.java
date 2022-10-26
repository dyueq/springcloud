package com.sc.controller;


import com.sc.bean.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PayController {

    public static HashMap<Integer,String> map = new HashMap<>();
    static {
        map.put(1,"123");
        map.put(2,"456");
        map.put(3,"789");
    }

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/paySQL/{id}")
    public Result getPay(@PathVariable("id") Integer id){
        String s = map.get(id);
        return new Result(200,"from HashMap,serverPort: " + serverPort + "\t id: " + id,s);
    }
}
