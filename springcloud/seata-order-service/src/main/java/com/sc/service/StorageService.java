package com.sc.service;

import com.sc.bean.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {
    //减少库存
    @PostMapping("/storage/decrease")
    Result decrease(@RequestParam("productId") Long product,@RequestParam("count") Integer count);
}
