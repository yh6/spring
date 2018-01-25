package com.iot.spring.dev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execute {
	
	public static void main(String[] agrs) {
		ApplicationContext factory;
		String path = "dev.";
		factory = new ClassPathXmlApplicationContext(path);
		OrderManager om = (OrderManager)factory.getBean("om");
		om.order();
		
	}

}
