package com.bogdan.controller;

import com.bogdan.model.Course;
import com.bogdan.model.Student;
import com.bogdan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public List<Student> readAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping(value = "/students/add")
    public ResponseEntity<?> create(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/students/{studentId}")
    public Student readStudent(@PathVariable int studentId) {
        return studentService.getStudent(studentId);
    }

    @GetMapping(value = "/courses")
    public List<Course> readAllCourses() {
        return studentService.getAllCourses();
    }

    @PostMapping(value = "/students/{studentId}/courses/add")
    public ResponseEntity<?> create(@PathVariable int studentId,
                                    @RequestBody Course course) {
        studentService.addCourse(studentId, course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/students/{studentId}/courses")
    public List<Course> read(@PathVariable int studentId) {
        return studentService.getAllCoursesStudent(studentId);
    }
}
