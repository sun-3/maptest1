package com.example.map3.service;

import com.example.map3.entities.Subject;

import java.util.List;

public interface SubjectService {

    public List<Subject> getSubjects();

    public Subject getSubject(Long subjectId);

    public Subject addSubject(Subject subject);
}
