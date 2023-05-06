package com.evergreen.university.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evergreen.university.course.entity.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long>{

}
