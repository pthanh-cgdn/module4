package com.codegyme.demo1.repositories.impl;

import com.codegyme.demo1.models.Student;
import com.codegyme.demo1.repositories.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();
    static{
        students.add(new Student(1,"HaiTT","Quang Nam",9));
        students.add(new Student(2,"HieuNT","Quang Tri",8.5f));
        students.add(new Student(3,"QuangLH","Ha Tinh",9.5f));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }
}
