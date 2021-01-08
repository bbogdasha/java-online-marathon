package com.bogdan.service;

import com.bogdan.model.Course;
import com.bogdan.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Map<Integer, Student> STUDENT_REPOSITORY = new HashMap<>();
    private static final AtomicInteger STUDENT_ID = new AtomicInteger();

    @Override
    public void addStudent(Student student) {
        final int studentId = STUDENT_ID.incrementAndGet();
        student.setId(studentId);
        STUDENT_REPOSITORY.put(studentId, student);
    }

    @Override
    public Student getStudent(int id) {
        for (Student student : STUDENT_REPOSITORY.values()) {
            if (student.getId() == id) {
                return STUDENT_REPOSITORY.get(id);
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(STUDENT_REPOSITORY.values());
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        for (Student student : getAllStudents()) {
            courses.addAll(student.getCourses());
        }
        return courses;
    }

    @Override
    public List<Course> getAllCoursesStudent(int studentId) {
        Student student = getStudent(studentId);
        if (student == null) {
            return null;
        }
        return student.getCourses();
    }

    @Override
    public void addCourse(int studentId, Course course) {
        Student student = getStudent(studentId);
        student.getCourses().add(course);
    }
}
