package cn.texous.testservice.service;

import org.springframework.stereotype.Component;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/20 17:58
 */
@Component
public class FirstHandler implements BaseHandler {

    @Override
    public void handler() {
        System.out.println("handler");
        handlerAfter();
    }

    protected void handlerAfter() {
        System.out.println("first handler after");
    }

}
