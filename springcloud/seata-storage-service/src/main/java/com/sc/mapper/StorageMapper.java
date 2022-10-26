package com.sc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {
    //减少库存
    void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
