package com.bogdan.repository;

import com.bogdan.model.Course;
import com.bogdan.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StudentDB {

    public static List<Student> getStudentList() {

        HashSet<Course> courses1 = new HashSet<>();
        List<String> steps1 = new ArrayList<>();
        steps1.add("Steps");
        steps1.add("Steps");
        steps1.add("Steps");
        courses1.add(new Course("Cyber", "Security info", steps1));

        List<String> steps2 = new ArrayList<>();
        steps2.add("Steps Steps");
        steps2.add("Steps Steps");
        steps2.add("Steps Steps");
        courses1.add(new Course("Programming", "Computer info", steps2));

        HashSet<Course> courses2 = new HashSet<>();
        courses2.add(new Course("Math", "Math info", new ArrayList<>()));

        List<Student> students = new ArrayList<>();

        Student student1 = new Student("Bobby", "Bobby info", courses1);
        Student student2 = new Student("Emily", "Emily info", new HashSet<>());
        Student student3 = new Student("Tom", "Tom info", courses2);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        return students;
    }
}
