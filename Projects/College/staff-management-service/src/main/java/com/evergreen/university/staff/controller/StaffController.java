package com.evergreen.university.staff.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evergreen.university.staff.entity.Staff;
import com.evergreen.university.staff.service.StaffService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/staff")
public class StaffController {
	
private Logger logger = LoggerFactory.getLogger(StaffController.class);
	
	private StaffService service;
	
	private StaffController(StaffService service) {
		this.service = service;
	}
	
	@GetMapping("/id/{id}")
	public Staff fetchStaff(@Valid @PathVariable Long id) {
		return service.fetchStaff(id);
		
	}
	
	@GetMapping("/")
	public List<Staff> fetchAllStaff() {
		List<Staff> list = service.fetchAllStaff();
		logger.info("fetchAllStaff {}",list);
		return list;
		
	}
	
	@PostMapping("/")
	public Staff saveStaff(@Valid @RequestBody Staff staff) {
		Staff st = service.saveStaff(staff);
		logger.info("Saved Staff Details are {} ",st);
		return st;
	}

}
