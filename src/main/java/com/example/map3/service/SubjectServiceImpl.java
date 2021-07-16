package com.example.map3.service;

import com.example.map3.dao.SubjectDao;
import com.example.map3.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao dao;

    @Override
    public List<Subject> getSubjects() {
        return dao.findAll();
    }

    @Override
    public Subject getSubject(Long subjectId) {
        return dao.findById(subjectId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Subject addSubject(Subject subject) {
        dao.save(subject);
        return subject;
    }
}
