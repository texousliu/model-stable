package cn.texous.dubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import cn.texous.TestService;
import org.springframework.stereotype.Component;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/8/21 2:53
 */
@Component
@Service(interfaceClass = TestService.class, version = "2.0.0")
public class TestServiceImpl implements TestService {
    @Override
    public void add() {
        System.out.println("测试 service: test service");
    }
}
