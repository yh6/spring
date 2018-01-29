package com.iot.spring.anno5;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Named("o1")
public class Order {
	@Autowired 
	@Qualifier("kkk")
	private Maker m;  
	//해당 변수 테이터 타입인 interface으로 구현된 클래스가 2개 이상 존재할때 Autowired만 있으면 에러(뭔지를 몰라서 에러)-> 그래서 Qualifier로 지정해줘야한다.
	
	@Autowired 
	private List<Maker> mList;
	public void printMaker() {
		m.printName();
	}
	
	public void printMList() {
		for(Maker m: mList) {
			m.printName();
		}
	}
}
