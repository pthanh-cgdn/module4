package com.codegyme.module4_student.repositories;

import com.codegyme.module4_student.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IClassroomRepository extends JpaRepository<Classroom, Long> {
}
