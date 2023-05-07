package com.evergreen.university.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.evergreen.university.model.Student;


@FeignClient(name="student-service", url = "localhost:1010")
public interface FeignClientProxy {
	
	@GetMapping("/student/")
	public List<Student> fetchAllStudent();
	
}
