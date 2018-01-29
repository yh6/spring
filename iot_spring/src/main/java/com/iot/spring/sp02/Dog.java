package com.iot.spring.sp02;

public class Dog implements Action {

	@Override
	public void sleep() {
		System.out.println("돌진이가 잠을 잔다");
		
	}

	@Override
	public void eat() {
		System.out.println("돌진이가 밥을 먹는다");
		
	}

	@Override
	public void play() {
		System.out.println("돌진이가 놀고있다");
	}

}
