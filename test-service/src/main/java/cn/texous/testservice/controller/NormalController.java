package cn.texous.testservice.controller;

import cn.texous.common.constants.TexousResult;
import cn.texous.testservice.annotation.TexousBody;
import cn.texous.testservice.service.BaseHandler;
import cn.texous.testservice.utils.BeanTools;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

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

    @RequestMapping("/test4")
    public String rest1(HttpServletRequest req) throws IOException {
        String str = IOUtils.toString(req.getInputStream());
        System.out.println(str);
        JsonNode jsonNode = new ObjectMapper().readTree(str);
        JsonNode jsonNode1 = jsonNode.get("data");
        System.out.println(jsonNode1.toString());
        //获取请求方式
        System.out.println(req.getMethod());
        //获取项目名称
        System.out.println(req.getContextPath());
        //获取完整请求路径
        System.out.println(req.getRequestURL());
        //获取除了域名外的请求数据
        System.out.println(req.getRequestURI());
        //获取请求参数
        System.out.println(req.getQueryString());
        System.out.println("----------------------------------------------------------");
        //获取请求头
        String header = req.getHeader("user-Agent");
        System.out.println(header);
        header = header.toLowerCase();
        //根据请求头数据判断浏览器类型
        if(header.contains("chrome")){
            System.out.println("您的访问浏览器为谷歌浏览器");
        }else if(header.contains("msie")){
            System.out.println("您的访问浏览器为IE浏览器");
        }else if(header.contains("firefox")){
            System.out.println("您的访问浏览器为火狐浏览器");
        }else{
            System.out.println("您的访问浏览器为其它浏览器");
        }
        System.out.println("----------------------------------------------------------");
        //获取所有的消息头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        //获取获取的消息头名称，获取对应的值，并输出
        while(headerNames.hasMoreElements()){
            String nextElement = headerNames.nextElement();
            System.out.println(nextElement+":"+req.getHeader(nextElement));
        }
        System.out.println("----------------------------------------------------------");
        //根据名称获取此重名的所有数据
        Enumeration<String> headers = req.getHeaders("accept");
        while (headers.hasMoreElements()) {
            String string = (String) headers.nextElement();
            System.out.println(string);
        }
        return "redirect:https://www.baidu.com";
    }



}
