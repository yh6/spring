package com.iot.spring.sp1;



public class Designer implements Worker{

	@Override
	public void goTowork() {
		System.out.println("디자이너가 출근");
		
	}

	@Override
	public void work() {
		System.out.println("디자이너가 일함 ");
		
	}

	@Override
	public void getOffWork() {
		System.out.println("디자이너가 퇴근 ");
		
	}
	

}
