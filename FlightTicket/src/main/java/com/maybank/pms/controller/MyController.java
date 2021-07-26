package com.maybank.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.pms.model.CompanyDetails;

@RestController 
public class MyController {
	@Autowired
	CompanyDetails companyDetails;
	
	@GetMapping("/companyDetails")
	public String print() {
		return companyDetails.toString();
	}
}
