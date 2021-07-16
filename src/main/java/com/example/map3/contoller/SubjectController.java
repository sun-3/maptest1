package com.example.map3.contoller;


import com.example.map3.entities.Subject;
import com.example.map3.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubject(){
        return this.subjectService.getSubjects();
    }

    @GetMapping("/{subjectId}")
    public Subject getSubject(@PathVariable Long subjectId){
        return this.subjectService.getSubject(subjectId);
    }
    @PostMapping
    public Subject getSubject(@RequestBody Subject subject){
        return this.subjectService.addSubject(subject);
    }
}
