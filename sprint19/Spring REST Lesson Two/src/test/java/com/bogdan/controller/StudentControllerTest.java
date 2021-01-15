package com.bogdan.controller;

import com.bogdan.service.StudentService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
    private StudentService studentService;
}
