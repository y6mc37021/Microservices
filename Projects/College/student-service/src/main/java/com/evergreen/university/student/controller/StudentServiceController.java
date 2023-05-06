package com.evergreen.university.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evergreen.university.student.entity.Student;
import com.evergreen.university.student.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
//{{apiPath}}/environments/{{envID}}/users
public class StudentServiceController {
	
	private Logger logger = LoggerFactory.getLogger(StudentServiceController.class);
	
	@Value("${spring.application.name}")
	private String appname;
	
	@Value("${min.value.is}")
	private String minvalue;
	
	private StudentService service;
	
	private StudentServiceController(StudentService service) {
		this.service = service;
	}
	
	@GetMapping("/id/{id}")
	public Student fetchStudent(@Valid @PathVariable Long id) {
		System.out.println("Application Name :-"+appname);
		logger.info("Application Name {}",appname);
		return service.find(id);
		
	}
	
	@GetMapping("/")
	public List<Student> fetchAllStudent() {
		List<Student> list = service.findAll();
		logger.info("fetchAllStudent {}",list);
		return list;
		
	}
	
	@PostMapping("/")
	public Student saveStudent(@Valid @RequestBody Student student) {
		Student st = service.save(student);
		logger.info("Saved Student Details are {} ",st);
		return st;
	}

}
