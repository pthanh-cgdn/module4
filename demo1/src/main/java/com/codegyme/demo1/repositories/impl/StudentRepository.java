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

    @Override
    public void add(Student student) {
        student.setId(students.get(students.size()-1).getId()+1);
        students.add(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void editStudent(Student student) {
        for(Student s:students){
            if(s.getId() == student.getId()){
                s.setName(student.getName());
                s.setAddress(student.getAddress());
                s.setPoint(student.getPoint());
                break;
            }
        }
    }
}
