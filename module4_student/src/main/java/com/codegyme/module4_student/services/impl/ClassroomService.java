package com.codegyme.module4_student.services.impl;

import com.codegyme.module4_student.models.Classroom;
import com.codegyme.module4_student.repositories.IClassroomRepository;
import com.codegyme.module4_student.services.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private IClassroomRepository classroomRepository;

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }
}
