package com.iot.spring.sp02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Excute {
	
	private Action a;
	
	public Excute(Action a) {
		this.a = a;
	}
	public void setAction(Action a) {
		this.a = a;
	}
	public void printAction() {
		a.eat();
		a.play();
		a.sleep();
	}
	public static void main(String[] agrs) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Excute e = (Excute)ac.getBean("ex");
		e.printAction();
		e= (Excute)ac.getBean("ex1");
		e.printAction();
	}
	}

