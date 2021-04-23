package com.netmind.demo.dao;

import org.springframework.stereotype.Repository;

import com.netmind.demo.model.Employee;
import com.netmind.demo.model.Employees;

@Repository
public class EmployeeDao {

	private static Employees employees = new Employees();

	static {
		employees.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta",
				"howtodoinjava@netmind.com"));
		employees.getEmployeeList()
				.add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
		employees.getEmployeeList()
				.add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
	}

	public Employees getAllEmployees() {
		return employees;
	}

	public Employee addEmployee(Employee employee) {
		employees.getEmployeeList().add(employee);

		Employee employeeAdded = employees.getEmployeeList().stream()
				.filter(employeeSearched -> employee.getId()
						.equals(employeeSearched.getId()))
				.findAny().orElse(null);

		return employeeAdded;
	}
}
