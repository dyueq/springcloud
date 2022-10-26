package com.sc.service.impl;

import com.sc.mapper.StorageMapper;
import com.sc.service.StorageService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;


    @Override
    public void decrease(Long product, Integer count) {
        log.info("=======>全局事务ID"+ RootContext.getXID());
        log.info("减少库存");
        storageMapper.decrease(product,count);
    }
}
