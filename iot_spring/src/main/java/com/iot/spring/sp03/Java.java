package com.iot.spring.sp03;

import org.springframework.stereotype.Component;

@Component("ja")
public class Java implements Iot{

	@Override
	public void printName() {
		System.out.println("처음으로 java을 배웠습니다.");
		
	}
	
	

}
