package com.iot.spring.anno5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("aaa") //bean해줌
public class Audi implements Maker{

	@Override
	public void printName() {
		System.out.println("아우디");
		
	}
	
	

}
