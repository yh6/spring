package com.iot.spring.sp03;

import org.springframework.stereotype.Component;

@Component("js")
public class Jsp implements Iot{

	@Override
	public void printName() {		
			System.out.println("jsp도 배웠습니다.");
		}		
}
