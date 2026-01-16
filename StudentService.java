package com.example.studentmanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;


public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
