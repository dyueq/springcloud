package com.sc.service;

import java.math.BigDecimal;

public interface AccountService {
    //减少金额
    void decrease(Long userId, BigDecimal money);
}
