package com.netmind.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netmind.demo.dao.EmployeeRepository;
import com.netmind.demo.model.Employee;

@CrossOrigin
@RestController
public class EmployeeH2Controller {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path = "/h2employees", produces = "application/json")
	public ResponseEntity<List<Employee>> getH2Employees() {
		return ResponseEntity.ok(employeeRepository.findAll());
	}
}
