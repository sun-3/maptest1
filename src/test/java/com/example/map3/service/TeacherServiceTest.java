package com.example.map3.service;

import com.example.map3.dao.TeacherDao;
import com.example.map3.entities.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @MockBean
    private TeacherDao teacherDao;

    @Test
    public void addTeacherTest(){
        Teacher teacher = new Teacher();
        teacher.setName("sam");
        teacher.setEmail("sam@email.com");

        Mockito.when(teacherDao.save(teacher)).thenReturn(teacher);
        Assertions.assertEquals(teacher,teacherService.addTeacher(teacher));
    }

    @Test
    public void getTeacherByIdTest(){
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("sam");
        teacher.setEmail("sam@email.com");

        Mockito.when(teacherDao.findById(1L)).thenReturn(java.util.Optional.of(teacher));
        Assertions.assertEquals(teacher,teacherService.getTeacher(1L));
    }
}
