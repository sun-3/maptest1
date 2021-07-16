package com.example.map3.service;

import com.example.map3.dao.TeacherDao;
import com.example.map3.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDao dao;

    @Override
    public List<Teacher> getTeacher() {
        return dao.findAll();
    }

    @Override
    public Teacher getTeacher(Long teacherId) {
        return dao.findById(teacherId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        dao.save(teacher);
        return teacher;
    }
}
