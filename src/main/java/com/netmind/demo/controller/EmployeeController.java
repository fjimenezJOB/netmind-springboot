package com.netmind.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.netmind.demo.dao.EmployeeDao;
import com.netmind.demo.model.Employee;
import com.netmind.demo.model.Employees;

@CrossOrigin
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping(path = "/employees", produces = "application/json")
	public ResponseEntity<Employees> getEmployees() {
		return ResponseEntity.ok(employeeDao.getAllEmployees());
	}

	@GetMapping(path = "/employees/{id}", produces = "application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		return ResponseEntity.ok(employeeDao.getEmployeeById(id));
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(
			@Valid @RequestBody Employee employee) {
		return ResponseEntity.ok(employeeDao.addEmployee(employee));
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,
			@Valid @RequestBody Employee employee) {
		employeeDao.updateEmployee(id, employee);
		return ResponseEntity.ok(employeeDao.getEmployeeById(id));
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
		employeeDao.deleteEmployee(id);
		return ResponseEntity.ok().build();
	}
}
