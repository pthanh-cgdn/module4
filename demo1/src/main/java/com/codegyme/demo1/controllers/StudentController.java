package com.codegyme.demo1.controllers;

import com.codegyme.demo1.models.Student;
import com.codegyme.demo1.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/student")
    public String displayAllStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }
}
