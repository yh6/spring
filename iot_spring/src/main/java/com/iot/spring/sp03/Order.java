package com.iot.spring.sp03;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Named("o2")
public class Order {
	@Autowired
	@Qualifier("ja")
	private Iot i;
	
	@Autowired
	private List<Iot> mList;
	public void printIot() {
		i.printName();
	}
	
	public void printMList() {
		for(Iot i:mList) {
			i.printName();
		}
	}

}
