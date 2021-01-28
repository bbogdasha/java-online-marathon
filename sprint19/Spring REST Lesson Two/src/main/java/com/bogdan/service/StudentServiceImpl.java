package com.bogdan.service;

import com.bogdan.model.Course;
import com.bogdan.model.Student;
import com.bogdan.repository.StudentDao;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentServiceImpl implements StudentService {

    private static final List<Student> STUDENT_REPOSITORY = new ArrayList<>();
    private static final Map<Integer, Course> COURSE_REPOSITORY = new HashMap<>();

    private static final AtomicInteger COURSE_ID = new AtomicInteger();

    static {
        for (Student s : StudentDao.getStudentList()) {
            STUDENT_REPOSITORY.add(s);
            for (Course c : s.getCourses()) {
                int index = COURSE_ID.incrementAndGet();
                c.setId(index);
                COURSE_REPOSITORY.put(index, c);
            }
        }
    }

    @Override
    public void addStudent(Student student) {
        STUDENT_REPOSITORY.add(student);
    }

    @Override
    public Student getStudent(int id) {
        for (Student s : STUDENT_REPOSITORY) {
            if (s.getId() == id) {
                return STUDENT_REPOSITORY.get(id - 1);
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return STUDENT_REPOSITORY;
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(COURSE_REPOSITORY.values());
    }

    @Override
    public Set<Course> getAllCoursesStudent(int studentId) {
        Student student = getStudent(studentId);
        if (student != null) {
            return student.getCourses();
        }
        return null;
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
