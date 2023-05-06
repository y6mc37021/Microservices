package com.evergreen.university.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evergreen.university.course.entity.Courses;
import com.evergreen.university.course.repository.CoursesRepository;

@Service
public class CoursesService {
	
	private CoursesRepository repo;
	
	private CoursesService(CoursesRepository coursesRepository) {
		this.repo = coursesRepository;
	}
	
	public Courses fetchCourse(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Courses> fetchAllCourse() {
		return repo.findAll();
	}
	
	public Courses saveCourse(Courses courses) {
		return repo.save(courses);
	}

}
