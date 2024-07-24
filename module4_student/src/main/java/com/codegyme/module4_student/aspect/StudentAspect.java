package com.codegyme.module4_student.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class StudentAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @After("execution(* com.codegyme.module4_student.controllers.StudentController.*())")
    public void logAfterVisitStudentController(JoinPoint joinPoint) {
        logger.info("user access function " + joinPoint.getSignature().getName() + " at " + LocalDateTime.now());
    }
}
