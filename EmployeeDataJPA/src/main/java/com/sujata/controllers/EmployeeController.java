package com.sujata.controllers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sujata.bean.Employee;
import com.sujata.bean.EmployeePaySlip;
import com.sujata.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
//	@RequestMapping("/")
//	public ModelAndView openingPageController() {
//		return new ModelAndView("index");
//	}
	
	@RequestMapping("/")
	public String openingPageController() {
		return "index";
	}
	
	@RequestMapping("/inputForEmpSearch")
	public ModelAndView getEmpIDForSearchPage() {
		return new ModelAndView("inputEmpIdForSearch", "command", new Employee()); 
	}

	@ModelAttribute("departments")
	List<String> getDepartmentList(){
		Collection<Employee> emps=null;
		try {
			emps= employeeService.getAllEmployees();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emps.stream()
				.map(Employee::getDeptt)
				.distinct()
				.collect(Collectors.toList());
	}
	
	@ModelAttribute("empIds")
	List<Integer> getEmployeeIds(){
		Collection<Employee> emps=null;
		
		try {
			emps=employeeService.getAllEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emps.stream()
				.map(Employee::geteId)
				.collect(Collectors.toList());
	}
	
	@RequestMapping("/searchEmp")
	public ModelAndView searchEmpController(@ModelAttribute Employee emp) {
		Employee employee=null;
		try {
			employee=employeeService.findEmployee(emp.geteId());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(employee!=null) {
			return new ModelAndView("displayEmployee", "employee", employee);
		}
		return new ModelAndView("output", "message", "Employee with id "+emp.geteId()+" doesnot exist");
	}

	@RequestMapping("/insertEmployeePage")
	public ModelAndView insertEmpPageController() {
		return new ModelAndView("inputEmpDetails", "emp", new Employee());
	}
	
	@RequestMapping("/insertEmp")
	public ModelAndView insertEmployeeController(@ModelAttribute("emp") Employee emp ) {
		try {
			if(employeeService.saveEmployee(emp))
				return new ModelAndView("output", "message", "Employee Saved Successfully!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return new ModelAndView("output", "message", "Saving Employee Failed!");
	
	}
	
	@RequestMapping("/deleteEmployeePage")
	public String deleteEmployeePageController() {
		return "inputEmpForDelete";
	}
	
	@RequestMapping("/deleteEmp")
	public ModelAndView deleteEmployeeController(@RequestParam("empId") String id) {
		try {
			if(employeeService.removeEmployee(Integer.parseInt(id))) {
				return new ModelAndView("output","message","Employee with ID "+id+" deleted Successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("output","message","Employee with ID "+id+" deletion Failed!");
		
	}
	
	@RequestMapping("/getAllEmps")
	public ModelAndView getAllEmployeesController() {
		Collection<Employee> employees=null;
		try {
			employees=employeeService.getAllEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("displayAllEmployeesWithoutScriplets", "employees", employees);
	}
	
	@RequestMapping("/inputForSalaryPage")
	public ModelAndView inputIdForSalaryPageController() {
		return new ModelAndView("inputEmpForSalary", "command", new Employee());
	}
	
	@RequestMapping("/salarySlip")
	public ModelAndView salarySlip(@ModelAttribute Employee emp) {
		EmployeePaySlip employee = employeeService.salarySlip(emp.geteId());
		if(employee!=null)	
			return new ModelAndView("displaySalarySlip","employee", employee);
		else			
			return new ModelAndView("output","message","Employee with ID "+emp.geteId()+" not found");
	}
	
	@RequestMapping("/inputForSalaryUpdate")
	public ModelAndView inputIdForSalaryUpdateController() {
		return new ModelAndView("inputEmpIdForSalaryUpdate", "command", new Employee());
	}
	
	@RequestMapping("/salaryUpdate")
	public ModelAndView salaryUpdate(@ModelAttribute Employee emp, @RequestParam("update") String type) {
		emp = employeeService.getEmployeeById(emp.geteId());
		EmployeePaySlip employee = employeeService.salarySlip(emp.geteId());
		System.out.println(employee);
		System.out.println(emp);
		int sal = emp.getSalary();
		System.out.println(sal);
		if(type.equalsIgnoreCase("Decrement"))
			sal = (int) (sal * 0.9);
		else
			sal =(int) (sal * 1.1);
		System.out.println(sal);
		if(employeeService.updateSalary(emp.geteId(), sal))	
			return new ModelAndView("redirect:/getAllEmps","employee", employee);
		else			
			return new ModelAndView("output","message","Salary Updation Failed");
	}
}