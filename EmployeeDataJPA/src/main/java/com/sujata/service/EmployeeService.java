package com.sujata.service;

import java.util.Collection;

import com.sujata.bean.Employee;
import com.sujata.bean.EmployeePaySlip;

public interface EmployeeService {

	Collection<Employee> getAllEmployees();
	
	boolean saveEmployee(Employee employee);
	Employee findEmployee(int id);
	boolean removeEmployee(int id);
	EmployeePaySlip salarySlip(int id);
	boolean updateSalary(int id, int sal);
	Employee getEmployeeById(int id);
}
