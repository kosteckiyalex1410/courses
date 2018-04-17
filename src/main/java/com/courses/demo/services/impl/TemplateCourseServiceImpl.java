package com.courses.demo.services.impl;

import com.courses.demo.dao.CourseTemplateDao;
import com.courses.demo.model.CourseTemplate;
import com.courses.demo.services.TemplateCourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TemplateCourseServiceImpl implements TemplateCourseService {

    private CourseTemplateDao dao;

    @Override
    public void createNewCourse(CourseTemplate template) {
        dao.save(template);
    }

    @Override
    public List<CourseTemplate> getAllCourses() {
        return dao.findAll();
    }

    @Autowired
    public void setDao(CourseTemplateDao dao) {
        this.dao = dao;
    }
}
