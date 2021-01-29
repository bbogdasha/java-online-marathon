package com.bogdan.controller;

import com.bogdan.model.Course;
import com.bogdan.model.Student;
import com.bogdan.repository.StudentDao;
import com.bogdan.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//Spring предоставляет соответствующие аннотации: @MockBean @SpyBean
@WebMvcTest(StudentController.class)
//@ WebMvcTest сообщит Spring Boot о создании экземпляра только веб-слоя, а не всего контекста.
//Из-за этого тесты контроллера, использующие _ @ WebMvcTest _ , будут выполняться быстрее,
// чем при других подходах .
@AutoConfigureMockMvc
//Эта аннотация нужна для того, чтобы появилась возможность внедрить в тестовый класс бин MockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void getAllStudentsTest() throws Exception {
        Mockito.when(studentService.getAllStudents()).thenReturn(StudentDao.getStudentList());
        mockMvc.perform(MockMvcRequestBuilders
                .get("/students"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
                .andDo(print());
    }

    @Test
    public void addStudentTest() throws Exception {
        String exampleStudentJson = "{\"id\":\"1\",\"name\":\"Bob\",\"surname\":\"Black\",\"courses\":[]}";
        mockMvc.perform(MockMvcRequestBuilders
                .post("/students/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(exampleStudentJson))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void getStudentByIdTest() throws Exception {
        Student student = new Student(1, "Bobby", "Red", new HashSet<>());
        Mockito.when(studentService.getStudent(1)).thenReturn(student);
        mockMvc.perform( MockMvcRequestBuilders
                .get("/students/{studentId}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bobby"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Red"))
                .andDo(print());
    }

    @Test
    public void getAllCoursesTest() throws Exception {
        List<Course> courses = StudentDao.getStudentList()
                .stream()
                .map(Student::getCourses)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Mockito.when(studentService.getAllCourses()).thenReturn(courses);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/courses"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
                .andDo(print());
    }

    @Test
    public void getCursesStudentTest() throws Exception {
        Set<Course> courses = StudentDao.getStudentList()
                .stream()
                .filter(x -> x.getId() == 1)
                .map(Student::getCourses)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        Mockito.when(studentService.getAllCoursesStudent(1)).thenReturn(courses);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/students/{studentId}/courses", 1))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Cyber security"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].info").value("Cyber security is the practice of \" +\n" +
                        "                \"defending computers, servers, mobile devices, electronic systems, networks, and \" +\n" +
                        "                \"data from malicious attacks."))
                .andDo(print());
    }
}
