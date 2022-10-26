package com.sc.service.impl;

import com.sc.bean.Pay;
import com.sc.mapper.PayMapper;
import com.sc.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayMapper payMapper;

    //新增
    @Override
    public int create(Pay pay) {
        return payMapper.create(pay);
    }

    //查询
    @Override
    public Pay getPayByID(Long id) {
        return payMapper.getPayByID(id);
    }
}
