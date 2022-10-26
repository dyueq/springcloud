package com.sc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConfigController {

    @Autowired
    private ConfigData configData;

    @GetMapping("/configInfo")
    private String getConfigInfo(){
        return configData.getConfigInfo();
    }

}