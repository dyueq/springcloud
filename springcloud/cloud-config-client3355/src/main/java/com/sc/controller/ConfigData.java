package com.sc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
//注解写在controller会返回null
//实现自动刷新配置，需要更改配置后发送一条POST请求来刷新服务
@RefreshScope
public class ConfigData {

    @Value("${config.info}")
    private String configInfo;

    public String getConfigInfo(){
        return configInfo;
    }
}
