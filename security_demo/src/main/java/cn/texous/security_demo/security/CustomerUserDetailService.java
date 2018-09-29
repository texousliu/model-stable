package cn.texous.security_demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/9/17 17:14
 */
@Component
public class CustomerUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User.UserBuilder builder = User.builder();
        builder.username("admin").password("123456").roles("admin");
        return builder.build();
    }

}
