package com.iot.spring.vo;

public class Emp {
	
	   private int empNO;
	   private String empName;
	   private int empSal;

	public int getEmpNO() {
		return empNO;
	}
	public void setEmpNO(int empNO) {
		this.empNO = empNO;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "Emp [empNO=" + empNO + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

	

}
