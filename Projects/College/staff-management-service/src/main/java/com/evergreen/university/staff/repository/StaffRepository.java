package com.evergreen.university.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evergreen.university.staff.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
