package cn.texous.testservice.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/18 11:04
 */
@Configuration
@EnableWebMvc
@EnableAutoConfiguration
public class WebMvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
//        handlers.add(texousBodyMethodProcessor());
//    }
//
//    public TexousBodyMethodProcessor texousBodyMethodProcessor() {
//        return new TexousBodyMethodProcessor();
//    }

    //    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.enableContentNegotiation(new MappingJackson2JsonView());
//        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
//        resourceViewResolver.setPrefix("/WebApp/WEB-INF/template/");
//        resourceViewResolver.setSuffix(".html");
//        registry.viewResolver(resourceViewResolver);
//    }
}
