package com.example.map3.service;

import com.example.map3.dao.CourseDao;
import com.example.map3.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao dao;

    @Override
    public List<Course> getCourses() {
        return dao.findAll();
    }

    @Override
    public Course getCourse(Long courseId) {
        return dao.findById(courseId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Course addCourse(Course course) {
        dao.save(course);
        return course;
    }
}
