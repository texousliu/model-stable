package com.texous.dubboconsumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.texous.dubboconsumer.service.ConsumerService;
import com.texous.TestService;
import org.springframework.stereotype.Component;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/21 3:18
 */
@Component
@Service(interfaceClass = ConsumerService.class)
public class ConsumerSerivceImpl implements ConsumerService {

    @Reference(version = "2.0.0")
    private TestService testService;

    @Override
    public void add() {
        testService.add();
    }
}
