package com.codegyme.demo1.services.impl;

import com.codegyme.demo1.models.Student;
import com.codegyme.demo1.repositories.impl.StudentRepository;
import com.codegyme.demo1.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
