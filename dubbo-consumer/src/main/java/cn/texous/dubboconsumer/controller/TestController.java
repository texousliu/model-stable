package cn.texous.dubboconsumer.controller;

import cn.texous.dubboconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/21 3:32
 */
@RestController
public class TestController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/test")
    public String get() {
        consumerService.add();
        return "test";
    }

}
