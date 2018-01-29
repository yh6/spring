package com.iot.spring.sp03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exeute {
	
	public static void main(String[] agrs) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sp03/ioc.xml");
		Order i = (Order)ac.getBean("o2");
		i.printMList();
	}

}
