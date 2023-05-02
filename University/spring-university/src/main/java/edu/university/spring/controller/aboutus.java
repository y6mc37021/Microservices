package edu.university.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edu")
public class aboutus {
	
	@RequestMapping("/history")
	public String history(){
		return "Spring University History About Come..";
	}
	

}
