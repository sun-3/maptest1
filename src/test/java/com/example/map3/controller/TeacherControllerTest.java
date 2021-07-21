package com.example.map3.controller;


import com.example.map3.contoller.TeacherController;
import com.example.map3.entities.Teacher;
import com.example.map3.service.TeacherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TeacherController.class)
public class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherService teacherService;

    @Test
    public void getTeacherByIdTest() throws Exception {
        Teacher mockTeacher = new Teacher();
        mockTeacher.setId(1L);
        mockTeacher.setName("sam");
        mockTeacher.setEmail("sam@email.com");

        Mockito.when(teacherService.getTeacher(Mockito.anyLong())).thenReturn(mockTeacher);

        String URI = "/teachers/1";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(mockTeacher);
        String outputJson = result.getResponse().getContentAsString();
        assertThat(outputJson).isEqualTo(expectedJson);

    }
    //Maps an Object into a string uses jackson objectmapper
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}

//}
/*
{"id":1,"name":"harsh","email":"hars@gmail.com"}
 */
