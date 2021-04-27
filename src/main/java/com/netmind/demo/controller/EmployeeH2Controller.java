package com.netmind.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netmind.demo.dao.EmployeeRepository;
import com.netmind.demo.model.Employee;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeH2Controller {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path = "/employees", produces = "application/json")
	public ResponseEntity<List<Employee>> getH2Employees() {
		return ResponseEntity.ok(employeeRepository.findAll());
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeRepository.save(employee));
	}
}