package com.codegyme.module4_student.services;

import com.codegyme.module4_student.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Page<Student> findAllByName(String name, Pageable pageable);
}
