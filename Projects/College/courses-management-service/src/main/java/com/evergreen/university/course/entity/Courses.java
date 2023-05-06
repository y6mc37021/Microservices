package com.evergreen.university.course.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "The first course name is required.")
	@Size(min = 2, max = 100, message = "The length of course name must be between 2 and 100 characters.")
	private String name;
	
	private String description;
	
	public Courses() {
		super();
	}

	public Courses(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", description=" + description + ", name=" + name + "]";
	}
	
	
	
	

}
