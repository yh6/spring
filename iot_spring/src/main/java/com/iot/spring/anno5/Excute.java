package com.iot.spring.anno5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Excute {

	
	public static void main(String[] ags) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("anno5/ioc.xml"); //프리로딩(다(new) 셋팅해줌(
		//Maker m = (Maker) ac.getBean("kia");
		Order m = (Order) ac.getBean("o1");
		m.printMaker();
		m.printMList();
//	    m = (Maker) ac.getBean("kia");
//		System.out.println(m);
	}
}
