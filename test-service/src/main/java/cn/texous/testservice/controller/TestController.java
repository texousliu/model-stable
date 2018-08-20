package cn.texous.testservice.controller;

import cn.texous.common.constants.TexousResult;
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
    public TexousResult getName() {
        System.out.println("getName: 8002");
        return TexousResult.ok("你是谁");
    }

}
