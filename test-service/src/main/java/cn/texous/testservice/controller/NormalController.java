package cn.texous.testservice.controller;

import cn.texous.common.constants.TexousResult;
import cn.texous.testservice.annotation.TexousBody;
import cn.texous.testservice.service.BaseHandler;
import cn.texous.testservice.utils.BeanTools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/18 8:31
 */
@Controller
public class NormalController {

    @RequestMapping("/test")
    @ResponseBody
    public TexousResult rest(@RequestParam String name) {
        System.out.println("test request" + name);
        BeanTools.getBean(name, BaseHandler.class).handler();
        return TexousResult.ok();
    }

    @RequestMapping("/test1")
    public String rest1(@RequestParam String name) {
        System.out.println("test1 request" + name);
        return "redirect:https://www.baidu.com";
    }

    @RequestMapping("/test2")
    public String rest2(@RequestParam String name) {
        System.out.println("test1 request" + name);
        return "redirect:https://www.baidu.com";
    }

    @RequestMapping("/test3")
    @TexousBody
    public TexousResult rest3(@RequestParam String name) {
        System.out.println("test request" + name);
        return TexousResult.ok();
    }

}
