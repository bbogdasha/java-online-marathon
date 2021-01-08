package com.bogdan.service;

import com.bogdan.model.Course;
import com.bogdan.model.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    Student getStudent(int id);

    List<Student> getAllStudents();

    void addCourse(int studentId, Course course);

    List<Course> getAllCoursesStudent(int studentId);

    List<Course> getAllCourses();
}
