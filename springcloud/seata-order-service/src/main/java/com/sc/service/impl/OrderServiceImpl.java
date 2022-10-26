package com.sc.service.impl;

import com.sc.bean.Order;
import com.sc.mapper.OrderMapper;
import com.sc.service.AccountService;
import com.sc.service.OrderService;
import com.sc.service.StorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;
    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void creatOrder(Order order) {

        log.info("=======>全局事务ID"+ RootContext.getXID());
        log.info("=======>创建订单");
        orderMapper.createOrder(order);

        log.info("=======>减少库存");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("=======>减少账户金额");
        accountService.decrease(order.getUserId(),order.getMoney());

        log.info("=======>修改订单状态，0--->1");
        orderMapper.updateOrder(order.getUserId(),0);

        log.info("=======>下单完成啦！！！！！");
    }
}
