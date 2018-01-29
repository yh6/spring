package com.iot.spring.sp03;

import org.springframework.stereotype.Component;

@Component("sp")
public class Spring implements Iot {

	@Override
	public void printName() {
		System.out.println("현재 spring 배우는 중입니다.");		
	}

}
