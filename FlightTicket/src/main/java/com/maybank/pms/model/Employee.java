package com.maybank.pms.model;

public class Employee {
	private int employeeId;
	private String employeeName;
	private String employeeAddress;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeId, String employeeName, String employeeAddress) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [employeeId=");
		builder.append(employeeId);
		builder.append(", employeeName=");
		builder.append(employeeName);
		builder.append(", employeeAddress=");
		builder.append(employeeAddress);
		builder.append("]");
		return builder.toString();
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	

}
