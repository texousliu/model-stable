package cn.texous.security_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/9/17 17:08
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String ger() {
        System.out.println("test");
        return "test";
    }

}
