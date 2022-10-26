package com.sc.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        //通过配置使访问http://localhost:9527/guonei该地址转发到http://news.baidu.com/guonei
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("path_route2",r -> r.path("/game").uri("http://news.baidu.com/game")).build();
        return routes.build();
    }
//    @Bean
//    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
//        //通过配置使访问http://localhost:9527/game该地址转发到http://news.baidu.com/game
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        routes.route("path_route",r -> r.path("/game").uri("http://news.baidu.com/game")).build();
//        return routes.build();
//    }
}
