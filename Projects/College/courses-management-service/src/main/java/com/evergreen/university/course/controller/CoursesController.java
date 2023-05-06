package com.evergreen.university.course.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evergreen.university.course.entity.Courses;
import com.evergreen.university.course.service.CoursesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CoursesController {
	
	private Logger logger = LoggerFactory.getLogger(CoursesController.class);
	
	private CoursesService service;
	
	private CoursesController(CoursesService service) {
		this.service = service;
	}
	
	@GetMapping("/id/{id}")
	public Courses fetchCourses(@Valid @PathVariable Long id) {
		return service.fetchCourse(id);
		
	}
	
	@GetMapping("/")
	public List<Courses> fetchAllStudent() {
		List<Courses> list = service.fetchAllCourse();
		logger.info("fetchAllCourses {}",list);
		return list;
		
	}
	
	@PostMapping("/")
	public Courses saveCourses(@Valid @RequestBody Courses courses) {
		Courses st = service.saveCourse(courses);
		logger.info("Saved Student Details are {} ",st);
		return st;
	}
}
