package cn.texous.beetl_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/9/7 0:42
 */
@Controller
@RequestMapping
public class TestController {

    @RequestMapping("/test")
    public ModelAndView getTest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("word", "this is my world");
        return modelAndView;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public Map<String, Object> rest() {
        Map<String, Object> result = new HashMap<>();
        result.put("aaaa", "aaaaa");
        result.put("bbbb", "bbbb");
        result.put("cccc", "cccc");

        return  result;
    }

}
