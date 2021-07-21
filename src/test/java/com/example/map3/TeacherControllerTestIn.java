package com.example.map3;


import com.example.map3.entities.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Map3Application.class)
public class TeacherControllerTestIn {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    private HttpHeaders headers = new HttpHeaders();

    @Test
    public void addTeachTest() throws JsonProcessingException {
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("sam");
        teacher.setEmail("sam@email.com");

        String URItoadd = "/teachers";

        String inputInJson = this.mapToJson(teacher);

        HttpEntity<Teacher> entity = new HttpEntity<Teacher>(teacher, headers);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(formFullURLWithPort(URItoadd),
                HttpMethod.POST, entity, String.class);
        String responseToJson = responseEntity.getBody();
        assertThat(responseToJson).isEqualTo(inputInJson);

    }
    //Maps an Object into a string uses jackson objectmapper

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);

    }
    //this create the url for given uri,it appends the RANDOM_PORT generated port
    private String formFullURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }
}
/*
{"id":1,"name":"harsh","email":"hars@gmail.com"}
 */
//