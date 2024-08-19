package com.zemoso.formvalidation.services;

import com.zemoso.formvalidation.model.Student;

import java.util.List;

public interface iStudentService {
    void registerStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(String enrollmentNumber);
    void removeStudentById(String enrollmentNumber);
}
