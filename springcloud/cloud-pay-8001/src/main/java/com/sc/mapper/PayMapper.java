package com.sc.mapper;

import com.sc.bean.Pay;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayMapper {
    //新增
    int create(Pay pay);
    //查询
    Pay getPayByID(@Param("id") Long id);
}
