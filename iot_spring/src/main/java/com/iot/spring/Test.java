package com.iot.spring;

public class Test {
	private String test;
		
	public void setTestStr(String test) {  
		//setter주입-beans.xml name="testStr"같아야되며  set+첫글자대문자<(DI(Dependency Injection,invoke)
		this.test=test;
	}
	
	public void printTest() {
		System.out.println(test);
	}
	

}
