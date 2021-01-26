package com.bogdan.controller;

import com.bogdan.model.Course;
import com.bogdan.model.Student;
import com.bogdan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/students/add")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> readAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/students/{studentId}")
    public ResponseEntity<Student> readStudent(@PathVariable("studentId") int studentId) {
        Student student = studentService.getStudent(studentId);
        return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/students/{studentId}/courses/add")
    public ResponseEntity<?> create(@PathVariable int studentId,
                                    @RequestBody Course course) {
        studentService.addCourse(studentId, course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> readAllCourses() {
        List<Course> courses = studentService.getAllCourses();
        return courses != null && !courses.isEmpty()
                ? new ResponseEntity<>(courses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/students/{studentId}/courses")
    public ResponseEntity<Set<Course>> read(@PathVariable int studentId) {
        Set<Course> courses = studentService.getAllCoursesStudent(studentId);
        return courses != null && !courses.isEmpty()
                ? new ResponseEntity<>(courses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
