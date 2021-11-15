package com.sujata.bean;

public class EmployeePaySlip {
	private Employee employee;
	private Double da,hra,total;
	public EmployeePaySlip() {
		
	}
	public EmployeePaySlip(Employee employee, Double da, Double hra, Double total) {
		super();
		this.employee = employee;
		this.da = da;
		this.hra = hra;
		this.total = total;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Double getDa() {
		return da;
	}
	public void setDa(Double da) {
		this.da = da;
	}
	public Double getHra() {
		return hra;
	}
	public void setHra(Double hra) {
		this.hra = hra;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
}