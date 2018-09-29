package cn.texous.security_demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomerUserDetailService customerUserDetailService;

	private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);


	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return customerUserDetailService;
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return customerUserDetailService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().permitAll();
	}


}
