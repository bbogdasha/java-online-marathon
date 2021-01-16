package com.bogdan.controller;

import com.bogdan.model.Course;
import com.bogdan.model.Student;
import com.bogdan.service.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashSet;

@RunWith(SpringRunner.class)
//Spring предоставляет соответствующие аннотации: @MockBean @SpyBean
@WebMvcTest(value = StudentController.class)
//@ WebMvcTest сообщит Spring Boot о создании экземпляра только веб-слоя, а не всего контекста.
//Из-за этого тесты контроллера, использующие _ @ WebMvcTest _ , будут выполняться быстрее,
// чем при других подходах .
@WithMockUser
//Поскольку MockMvc настроен для нас, мы можем использовать @ WithMockUser для наших
// тестов без какой-либо дополнительной настройки
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentServiceImpl studentService;

    String exampleCourseJson = "{\"name\":\"Spring\",\"info\":\"10Steps\",\"steps\":[]}";
    Course course = new Course("Spring", "Spring info", new ArrayList<>());

    String exampleStudentJson = "{\"name\":\"Bob\",\"info\":\"Bob info\",\"courses\":[]}";
    Student exampleStudentPojo = new Student("Nick", "Nick info", new HashSet<>());

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createStudentTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/students/add")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(exampleStudentPojo));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void createCourseTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/students/1/courses/add")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(exampleStudentPojo));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void retrieveDetailsForCourse() throws Exception {
        RequestBuilder requestBuilderGet = MockMvcRequestBuilders
                .get("/students/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilderGet).andReturn();

        String expected = "{id:1,name:Nick,info:Nick info,courses:[]}";

        String json = result.getResponse().getContentAsString();
        System.out.println("JSON: " + json);
        System.out.println("STRING: " + expected);

//        JSONAssert.assertEquals(expected,
//                result.getResponse().getContentAsString(), false);
    }
}
