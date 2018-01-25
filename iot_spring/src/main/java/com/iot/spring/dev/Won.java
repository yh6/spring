package com.iot.spring.dev;

import org.springframework.stereotype.Component;


@Component("Won") //bean을 생성하기 위한 애너테이션
public class Won {
	private int money;

	public int getMoney() {
		return money;
	}
	public Won() {
		System.out.println("원이 생성된다고??");
	}
	public void setMoney(int money) {
		this.money = money;
	}

}
