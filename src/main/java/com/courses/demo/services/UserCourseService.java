package com.courses.demo.services;

import com.courses.demo.model.Course;
import com.courses.demo.model.User;

import java.util.List;

public interface UserCourseService {

    Course getCurrentCourseByUser(User user);
    List<Course> getAllCoursesByUser(User user);
}
