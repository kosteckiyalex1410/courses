package com.courses.demo.services;

import com.courses.demo.model.CourseTemplate;

import java.util.List;

public interface TemplateCourseService {

    void createNewCourse(CourseTemplate courseTemplate);
    List<CourseTemplate> getAllCourses();

}
