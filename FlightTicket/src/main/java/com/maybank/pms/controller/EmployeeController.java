package com.maybank.pms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.pms.model.Employee;
@RestController
@RequestMapping("employee")
public class EmployeeController {
	List<Employee> employees = Arrays.asList(
			new Employee(101, "Varun", "Kolar"),
			new Employee(102, "Sarthak", "Blore"),
			new Employee(103, "Tufail", "Pune"));
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employees;
	}
	@PostMapping
	public String AddProduct2(@RequestBody Employee employee) {
	return "employee added : "+employee;
	}
	@PutMapping
	public String UpdateProduct(@RequestBody Employee employee) {
		return "employee updated : "+ employee;
	}
	
	@DeleteMapping("/delete/{employeeId}")
	public String DeleteProduct(@PathVariable("employeeId")int employeeId) {
		return "employee to be deleted has Id : " + employeeId;
	}

	@GetMapping("/search/{employeeId}")
	public String searchProduct(@PathVariable("employeeId")int employeeId) {
		return "employee to be searcged has Id : " + employeeId;
	}
	@GetMapping("/searchbyname/{employeeName}")
	public String searchProduct(@PathVariable("employeeName")String employeeName) {
		return "employee to be searched has name : " + employeeName;
	}
	@GetMapping("/filterbysalary/{lowerBound}/and/{upperBound}")
	public String filterBySalary(@PathVariable("lowerBound")int lowerBound,
			@PathVariable("upperBound") int upperBound) {
		return "Details of employees having salary between : " + lowerBound + " and " +upperBound;
	}
	
}
