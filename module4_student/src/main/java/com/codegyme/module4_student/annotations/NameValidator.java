package com.codegyme.module4_student.annotations;

import com.codegyme.module4_student.repositories.IStudentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NameValidator implements ConstraintValidator<NameValid, String> {

    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

        return false;
    }
}
