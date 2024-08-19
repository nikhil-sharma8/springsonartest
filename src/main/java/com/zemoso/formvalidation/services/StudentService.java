package com.zemoso.formvalidation.services;

import com.zemoso.formvalidation.config.AppConfig;
import com.zemoso.formvalidation.model.Student;
import com.zemoso.formvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements iStudentService{

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void registerStudent(Student student) {

        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String enrollmentNumber) {
        return studentRepository.findById(enrollmentNumber);
    }

    @Override
    public void removeStudentById(String enrollmentNumber) {
        studentRepository.deleteById(enrollmentNumber);
    }
}
