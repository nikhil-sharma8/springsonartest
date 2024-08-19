package com.zemoso.formvalidation.repository;

import com.zemoso.formvalidation.model.Student;

import java.util.List;

public interface iStudentRepository {
    void save(Student student);
    List<Student> findAll();
    Student findById(String enrollmentNumber);
    void deleteById(String enrollmentNumber);

}
