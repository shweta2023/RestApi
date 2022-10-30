package com.tests.models;

public class AddUserPOJO {
	 private String Accountno;
	  private String Departmnetno;
	  private String Salary;
	  private String Pincode;
	 
	public AddUserPOJO() {
		super();
		this.Accountno = Accountno;
		this.Departmnetno = Departmnetno;
		this.Salary = Salary;
		this.Pincode = Pincode;
	}
	public String getAccountno() {
		return Accountno;
	}
	public void setAccountno(String accountno) {
		Accountno = accountno;
	}
	public String getDepartmnetno() {
		return Departmnetno;
	}
	public void setDepartmnetno(String departmnetno) {
		Departmnetno = departmnetno;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	
	
}
