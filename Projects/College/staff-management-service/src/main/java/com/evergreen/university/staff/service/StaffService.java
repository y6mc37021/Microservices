package com.evergreen.university.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evergreen.university.staff.entity.Staff;
import com.evergreen.university.staff.repository.StaffRepository;

@Service
public class StaffService {
	
	private StaffRepository repo;
	
	private StaffService(StaffRepository staffRepository) {
		this.repo = staffRepository;
	}
	
	public Staff fetchStaff(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Staff> fetchAllStaff() {
		return repo.findAll();
	}
	
	public Staff saveStaff(Staff staff) {
		return repo.save(staff);
	}
}
