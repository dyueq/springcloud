package com.sc.service.impl;

import com.sc.mapper.AccountMapper;
import com.sc.service.AccountService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("=======>全局事务ID"+ RootContext.getXID());
        int age = 1/0;
        log.info("减少账户余额");
        accountMapper.decrease(userId,money);
    }
}
