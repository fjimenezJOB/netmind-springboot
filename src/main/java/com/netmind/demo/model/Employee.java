package com.netmind.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message = "The id should not be null")
	@Positive(message = "The id cannot be negative")
	private Integer id;

	@Column(name = "firstName")
	@NotBlank(message = "The first name should not be blank or null")
	private String firstName;

	@Column(name = "lastName")
	@NotBlank(message = "The last name should not be blank or null")
	private String lastName;

	@Column(name = "email")
	@Email(message = "This is an incorrect email address")
	@NotBlank(message = "The email address should not be blank or null")
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee() {

	}

	public Employee(Integer id, String firstName, String lastName,
			String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ",lastName="
				+ lastName + ", email=" + email + "]";
	}
}
