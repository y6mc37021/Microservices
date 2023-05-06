package com.evergreen.university.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evergreen.university.student.entity.Student;
import com.evergreen.university.student.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository repo;
	
	private StudentService(StudentRepository repository){
		this.repo = repository;
	}
	
	public Student save(Student student) {
		return repo.save(student);
	}
	
	public Student find(Long i) {
		return repo.findById(i).orElse(null);
	}
	
	public List<Student> findAll(){
		return repo.findAll();
	}
	

}
