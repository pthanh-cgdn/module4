package com.codegyme.demo1.controllers;

import com.codegyme.demo1.models.Student;
import com.codegyme.demo1.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("/student/create")
    public String createStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/create";
    }
    @PostMapping("/student/create")
    public String createStudent(@ModelAttribute Student student, BindingResult bindingResult, RedirectAttributes redirect) {
//            @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("point") Float point) {
        studentService.add(student);

        return "redirect:/student";
    }
    @GetMapping("/student/edit/{id}")
    public String editStudents(@PathVariable("id") Integer id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/edit";
    }
    @PostMapping("student/edit/{id}")
    public String editStudent(@PathVariable("id") Integer id,@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("point") String point ) {
        Student student = new Student(id,name,address,Float.parseFloat(point));
        studentService.editStudent(student);
        return "redirect:/student";
    }
}
