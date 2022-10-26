package com.sc.service;

public interface StorageService {
    //减少库存
    void decrease(Long product,Integer count);
}
