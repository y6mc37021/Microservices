package com.evergreen.university.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "The first name is required.")
	@Size(min = 2, max = 100, message = "The length of last name must be between 2 and 100 characters.")
	private String firstName;
	
	@NotEmpty(message = "The last name is required.")
	@Size(min = 2, max = 100, message = "The length of last  name must be between 2 and 100 characters.")
	private String lastName;

	@NotEmpty(message = "The gender is required.")
	private String sex;
	
	@NotEmpty(message = "The full name is required.")
	@Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
	private Long mobile;
	
	public Student() {
		super();
	}

	public Student(Long id, String firstName, String lastName, String sex, Long mobile) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.mobile = mobile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex
				+ ", mobile=" + mobile + "]";
	}
	
	
}
