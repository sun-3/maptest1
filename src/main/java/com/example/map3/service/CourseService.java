package com.example.map3.service;

import com.example.map3.entities.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourse(Long courseId);

    public Course addCourse(Course course);

}
