package cn.texous.testservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/17 10:17
 */
@RestController
public class TestController {

    @GetMapping("/getName")
    public String getName() {
        System.out.println("getName: 8002");
        return "dddd";
    }

}
