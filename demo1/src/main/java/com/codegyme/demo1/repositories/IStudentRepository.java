package com.codegyme.demo1.repositories;

import com.codegyme.demo1.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void add(Student student);

    Student getStudentById(Integer id);

    void editStudent(Student student);
}
