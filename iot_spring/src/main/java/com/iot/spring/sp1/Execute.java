package com.iot.spring.sp1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execute {
	
	private Worker w;
	
	public Execute(Worker w) {
		this.w = w;
	}
	public void setWorker(Worker w) {
		this.w=w;
	}
	public void printWorker() {
		w.goTowork();
		w.work();
		w.getOffWork();
	}
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans6.xml");
		Execute e = (Execute)ac.getBean("ex");
		e.printWorker();
		//e.w.goTowork();
	}
}
