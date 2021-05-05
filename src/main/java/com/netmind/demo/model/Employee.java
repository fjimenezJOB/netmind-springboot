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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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
}
