package com.sc.controller;

import com.sc.bean.Result;
import com.sc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public Result decrease(Long userId, BigDecimal money){
        accountService.decrease(userId, money);
        return new Result(200,"账号金额修改成功");
    }
}
