package com.sc.mapper;

import com.sc.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface OrderMapper {
    //新建订单
    void createOrder(Order order);

    //修改订单状态
    void updateOrder(@Param("userId") Long userId,@Param("status") Integer status);
}
