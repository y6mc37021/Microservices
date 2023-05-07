package com.evergreen.university.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.evergreen.university.client.FeignClientProxy;
import com.evergreen.university.model.Student;



@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {
    
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@RestController
@RequestMapping("/university/api")
public class UniversityManagementController {
	
	private Logger logger = LoggerFactory.getLogger(UniversityManagementController.class);
	@Autowired
	private Environment env;
	
	private FeignClientProxy client;
	
	@Autowired
	private RestTemplate rest;
	
	private UniversityManagementController(FeignClientProxy client) {
		this.client = client;
	}
	
	
	@GetMapping("/getAllStudentsRest")
	public List<Student> getStudentDetailsRest() {
		logger.info("getStudentDetailsRest...");
		
		HashMap<Long,Long> variables = new HashMap<Long,Long>();
		variables.put(1L,1L);
		//ResponseEntity<Student> entity =  rest.getForEntity("http://localhost:1010/student/", Student.class, variables);
		//Student student = entity.getBody();
		
		ResponseEntity<List<Student>> entity = rest.exchange(
				"http://localhost:1010/student/", 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Student>>() {});
		List<Student> student = entity.getBody();
		logger.info("Student Details {}",student);
		return student;
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getStudentDetails() {
		String appname = env.getProperty("spring.application.name");
		String appport = env.getProperty("server.port");
		logger.info("AppName::{} Appport::{}", appname, appport);
		
		List<Student> student= client.fetchAllStudent();
		
		//return " appname:: "+ appname +"\n appport:: "+appport;
		return student;
	}

}
