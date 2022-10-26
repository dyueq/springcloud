package com.sc.service;

import com.sc.bean.Pay;

public interface PayService {
    //新增
    int create(Pay pay);
    //查询
    Pay getPayByID(Long id);
}
