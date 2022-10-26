package com.sc.controller;

import com.sc.bean.Order;
import com.sc.bean.Result;
import com.sc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public Result create(Order order){
        orderService.creatOrder(order);
        return new Result(200,"订单创建成功");
    }
}
