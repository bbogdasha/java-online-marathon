package com.bogdan.controller;

import com.bogdan.repository.StudentDB;
import com.bogdan.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    String exampleCourseJson = "{\"name\":\"Spring\",\"info\":\"10Steps\",\"steps\":[]}";
//    Course course = new Course("Spring", "Spring info", new ArrayList<>());

    String exampleStudentJson = "{\"name\":\"Bob\",\"info\":\"Bob info\",\"courses\":[]}";
//    Student exampleStudentOnePojo = new Student("Nick", "Nick info", new HashSet<>());
//    Student exampleStudentTwoPojo = new Student("Bobby", "Bobby info", new HashSet<>());

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void init() throws Exception {
        System.out.println("++++");
//        List<Student> students = new ArrayList<>();
//        students.add(exampleStudentOnePojo);
//        students.add(exampleStudentTwoPojo);
        Mockito.when(studentService.getAllStudents()).thenReturn(StudentDB.getStudentList());
        System.out.println("++++");
    }

//    @Test
//    public void addStudentTest() throws Exception {
//        exampleStudentOnePojo.setId(1);
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/students/add")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(exampleStudentOnePojo)))
//                .andExpect(status().isCreated())
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Nick"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.info").value("Nick info"));
//    }

    @Test
    public void getEmployeeByIdAPI() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/students/{studentId}", 2)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bobby"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Bobby info"));
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
}
