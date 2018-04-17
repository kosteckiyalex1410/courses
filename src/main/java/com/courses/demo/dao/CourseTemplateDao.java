package com.courses.demo.dao;

import com.courses.demo.model.CourseTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTemplateDao extends JpaRepository<CourseTemplate, Long>
{
}
