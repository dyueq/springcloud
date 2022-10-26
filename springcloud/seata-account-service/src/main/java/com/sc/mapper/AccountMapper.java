package com.sc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper {
    //减少余额
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
