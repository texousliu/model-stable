package com.texous.dubboconsumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.texous.dubboconsumer.service.ConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDubboConfiguration
public class DubboConsumerApplicationTests {

    @Autowired
    private ConsumerService consumerService;

    @Test
    public void contextLoads() {
        consumerService.add();
    }

}
