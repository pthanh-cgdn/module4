package com.codegyme.module4_student.controllers;

import com.codegyme.module4_student.models.Student;
import com.codegyme.module4_student.repositories.IStudentRepository;
import com.codegyme.module4_student.services.IStudentService;
import com.codegyme.module4_student.services.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IStudentRepository studentRepository;
    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.BAD_REQUEST);
    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        if (studentRepository.findById(student.getId()).isPresent()){
            studentRepository.save(student);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@RequestBody Student student) {
        studentRepository.delete(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

}
