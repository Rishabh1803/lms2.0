package com.sujata.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")

public class Employee {

	@Id
	@Column(name = "ID")
	private Integer eId;
	@Column(name = "Name")
	private String eName;
	@Column(name = "Department")
	private String deptt;
	@Column(name = "Designation")
	private String desig;
	@Column(name = "Salary")
	private int salary;

	public Employee() {

	}

	public Employee(int eId, String eName, String deptt, String desig, int salary) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.deptt = deptt;
		this.desig = desig;
		this.salary = salary;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getDeptt() {
		return deptt;
	}

	public void setDeptt(String deptt) {
		this.deptt = deptt;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return eId + "\t" + eName + "\t" + deptt + "\t" + desig + "\t" + salary;
	}
}