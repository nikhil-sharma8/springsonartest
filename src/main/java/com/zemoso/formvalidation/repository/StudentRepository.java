package com.zemoso.formvalidation.repository;

import com.zemoso.formvalidation.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements iStudentRepository{
    private final List<Student> students = new ArrayList<>();

    StudentRepository(){
        students.add(new Student("Nikhil", "Sharma", "ZEMrui", "1234567890", 55.69, 'M', "nikhil@zemoso.com"));
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findById(String enrollmentNumber) {
        return students.stream().filter(student -> enrollmentNumber.equals(student.getEnrollmentNo())).findFirst().orElse(null);
    }

    @Override
    public void deleteById(String enrollmentNumber) {
        students.removeIf(student -> enrollmentNumber.equals(student.getEnrollmentNo()));
    }
}
