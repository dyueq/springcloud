package com.sc.controller;

import com.sc.bean.Result;
import com.sc.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public Result decrease(Long productId,Integer count){
        storageService.decrease(productId,count);
        return new Result(200,"更改库存成功");
    }
}
