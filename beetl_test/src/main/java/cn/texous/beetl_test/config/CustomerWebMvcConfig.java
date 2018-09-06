package cn.texous.beetl_test.config;

import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/9/7 0:36
 */
@Configuration
public class CustomerWebMvcConfig implements WebMvcConfigurer {

    @Resource(name = "beetlViewResolver")
    private BeetlSpringViewResolver beetlSpringViewResolver;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(beetlSpringViewResolver);
    }
}
