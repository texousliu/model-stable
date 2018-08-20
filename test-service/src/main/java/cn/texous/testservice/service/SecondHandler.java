package cn.texous.testservice.service;

import org.springframework.stereotype.Component;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/20 17:59
 */
@Component
public class SecondHandler implements BaseHandler {

    @Override
    public void handler() {
        System.out.println("handler");
        afterHandler();
    }

    protected void afterHandler() {
        System.out.println("second after handler");
    }
}
