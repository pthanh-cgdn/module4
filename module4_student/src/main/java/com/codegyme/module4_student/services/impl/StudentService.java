package com.codegyme.module4_student.services.impl;

import com.codegyme.module4_student.models.Student;
import com.codegyme.module4_student.repositories.IStudentRepository;
import com.codegyme.module4_student.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Page<Student> findAllByName(String name, Pageable pageable) {
        return studentRepository.findAllByNameContaining("%"+ name+"%", pageable);
    }
}
