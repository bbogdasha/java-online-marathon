package com.bogdan.service;

import com.bogdan.model.Course;
import com.bogdan.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Map<Integer, Student> STUDENT_REPOSITORY = new HashMap<>();
    private static final Map<Integer, Course> COURSE_REPOSITORY = new HashMap<>();
    private static final AtomicInteger STUDENT_ID = new AtomicInteger();
    private static final AtomicInteger COURSE_ID = new AtomicInteger();

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
        return new ArrayList<>(COURSE_REPOSITORY.values());
    }

    @Override
    public Set<Course> getAllCoursesStudent(int studentId) {
        Student student = getStudent(studentId);
        if (student == null) {
            return null;
        }
        return student.getCourses();
    }

    @Override
    public void addCourse(int studentId, Course course) {
        boolean isNewCourse = true;
        Student student = getStudent(studentId);

        for (Course c : getAllCourses()) {
            if (c.getName().equals(course.getName()) && !student.getCourses().contains(course)) {
                student.getCourses().add(c);
                isNewCourse = false;
                break;
            }
        }

        if (isNewCourse) {
            final int courseId = COURSE_ID.incrementAndGet();
            course.setId(courseId);
            COURSE_REPOSITORY.put(courseId, course);
            student.getCourses().add(course);
        }
    }
}
