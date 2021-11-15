package com.sujata.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujata.bean.Employee;
import com.sujata.bean.EmployeePaySlip;
import com.sujata.persistence.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Collection<Employee> getAllEmployees() {

		return employeeDao.findAll();
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		return employeeDao.save(employee) != null;
	}

	@Override
	public Employee findEmployee(int id) {
		return employeeDao.findById(id).get();
	}

	@Override
	public boolean removeEmployee(int id) {
		employeeDao.deleteById(id);
		return true;
	}

	@Override
	public EmployeePaySlip salarySlip(int id) {
		Employee employee = employeeDao.getById(id);
		EmployeePaySlip emp = new EmployeePaySlip();
		emp.setEmployee(employee);
		emp.setDa(employee.getSalary() * 0.1);
		emp.setHra(employee.getSalary() * 0.15);
		emp.setTotal(emp.getDa() + emp.getHra() + employee.getSalary());
		return emp;
	}

	@Override
	public boolean updateSalary(int id, int sal) {
		employeeDao.updateSalary(id, sal);
		return true;
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeDao.getById(id);
	}
}