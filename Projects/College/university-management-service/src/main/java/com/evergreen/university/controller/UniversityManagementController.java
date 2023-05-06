package com.evergreen.university.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/university/api")
public class UniversityManagementController {
	
	private Logger logger = LoggerFactory.getLogger(UniversityManagementController.class);
	@Autowired
	private Environment env;
	
	
	@GetMapping("/student")
	public String getStudentDetails() {
		String appname = env.getProperty("spring.application.name");
		String appport = env.getProperty("server.port");
		logger.info("AppName::{} Appport::{}", appname, appport);
		return " appname:: "+ appname +"\n appport:: "+appport;
	}

}
