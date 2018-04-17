package com.courses.demo.services.impl;

import com.courses.demo.dao.CourseDao;
import com.courses.demo.model.Course;
import com.courses.demo.model.User;
import com.courses.demo.services.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserCourseServiceImpl implements UserCourseService {

    private CourseDao courseDao;



    @Override
    public Course getCurrentCourseByUser(User user) {
        return courseDao.findById(user.getId()).get();
    }

    @Override
    public List<Course> getAllCoursesByUser(User user) {
        return courseDao.findAll();
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
}
