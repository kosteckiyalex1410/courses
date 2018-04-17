package com.courses.demo.dao;

import com.courses.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
