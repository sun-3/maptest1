package com.example.map3.contoller;


import com.example.map3.entities.Teacher;
import com.example.map3.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeacher(){

        return this.teacherService.getTeacher();
    }

    @GetMapping("/{teacherId}")
    public Teacher getTeacher(@PathVariable Long teacherId){
        return this.teacherService.getTeacher(teacherId);
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return this.teacherService.addTeacher(teacher);
    }
}
