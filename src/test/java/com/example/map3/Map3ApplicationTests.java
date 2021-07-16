package com.example.map3;

import com.example.map3.dao.TeacherDao;
import com.example.map3.entities.Teacher;
import com.example.map3.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class Map3ApplicationTests {
	@Autowired
	private TeacherService teacherService;

	@MockBean
	private TeacherDao dao;

	@Test
	public void getTeachersTest(){
		when(dao.findAll()).thenReturn(Stream.of(new Teacher(1L,"arsh","a@mail.com"),
				new Teacher(7L,"lupin","lk@mail.com")).collect(Collectors.toList()));
		assertEquals(2,teacherService.getTeacher().size());
	}

	@Test
	public void addTeacherTest(){
		Teacher teacher = new Teacher(2L,"hash","hkm@gmail.com");
		when(dao.save(teacher)).thenReturn(teacher);
		assertEquals(teacher,teacherService.addTeacher(teacher));
	}
}
