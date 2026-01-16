package com.example.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;


public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    
    public String viewHome(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "list";
    }

    
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    
    public String saveStudent( Student student) {
        service.saveStudent(student);
        return "redirect:/";
    }

    
    public String editStudent( Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "add";
    }

    
    public String deleteStudent( Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }
}

