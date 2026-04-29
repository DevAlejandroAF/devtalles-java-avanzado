package com.devtalles.proyecto.task.student.service;

import com.devtalles.proyecto.task.student.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAll() {
        return students;
    }
}
