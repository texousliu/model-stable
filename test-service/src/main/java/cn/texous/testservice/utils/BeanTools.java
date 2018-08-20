package cn.texous.testservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTools implements ApplicationContextAware {

	private static Logger logger = LoggerFactory.getLogger(BeanTools.class);

	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}

	public static <T> T getBean(Class<T> clazz) {
		try {
			return applicationContext.getBean(clazz);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static <T> T getBean(String name, Class<T> clazz) {
		try {
			return applicationContext.getBean(name, clazz);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	public static void setApplicationContextCustomer(ApplicationContext context) {
		applicationContext = context;
	}
}
