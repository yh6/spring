package com.iot.spring.anno5;

import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component("kkk")
//@Scope("prototype")-메뉴만들때사용적당
public class Kia implements Maker{
	
	public void printName() {
		System.out.println("기아");
		
	}

}
