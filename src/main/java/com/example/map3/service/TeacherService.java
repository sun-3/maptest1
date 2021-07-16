package com.example.map3.service;

import com.example.map3.entities.Teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> getTeacher();

    public Teacher getTeacher(Long teacherId);

    public Teacher addTeacher(Teacher teacher);
}
