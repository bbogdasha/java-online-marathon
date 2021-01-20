package com.bogdan.controller;

import com.bogdan.model.Course;
import com.bogdan.model.Student;
import com.bogdan.service.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentServiceImpl studentService;

    String exampleCourseJson = "{\"name\":\"Spring\",\"info\":\"10Steps\",\"steps\":[]}";
    Course course = new Course("Spring", "Spring info", new ArrayList<>());

    String exampleStudentJson = "{\"name\":\"Bob\",\"info\":\"Bob info\",\"courses\":[]}";
    Student exampleStudentPojo = new Student(1,"Nick", "Nick info", new HashSet<>());

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createStudentTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/students/add")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(exampleStudentPojo)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Nick"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.info").value("Nick info"));
    }

//    @Test
//    public void createCourseTest() throws Exception {
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/students/1/courses/add")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(exampleStudentPojo));
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//    }
//
//    @Test
//    public void retrieveDetailsForCourse() throws Exception {
//        RequestBuilder requestBuilderGet = MockMvcRequestBuilders
//                .get("/students/1")
//                .accept(MediaType.APPLICATION_JSON);
//
//
//        MvcResult result = mockMvc.perform(requestBuilderGet).andReturn();
//
//        String expected = "{id:1,name:Nick,info:Nick info,courses:[]}";
//
//        String json = result.getResponse().getContentAsString();
//        System.out.println("JSON: " + json);
//        System.out.println("STRING: " + expected);
//
//        JSONAssert.assertEquals(expected,
//                result.getResponse().getContentAsString(), false);
//    }
}
