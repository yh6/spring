package com.iot.spring.sp1;

public class Developer implements Worker {

	@Override
	public void goTowork() {	
		System.out.println("개발자 출근");
	}

	@Override
	public void work() {
		System.out.println("개발자 일함");
	}

	@Override
	public void getOffWork() {
		System.out.println("개발자 퇴근");
		
		
	}

}
