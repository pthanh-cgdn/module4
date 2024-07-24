package com.codegyme.library.aspect;

import jakarta.validation.Valid;
import lombok.Value;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class UserAspect {
    private static int visitorCount;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @AfterReturning(value = "execution(* com.codegyme.library.repositories.IBorrowedBookRepository.save(..))")
    public void logAfterBorrowABook(JoinPoint joinPoint) {
        logger.info("user borrowed a book at " + LocalDateTime.now());
    }
    @AfterReturning("execution(* com.codegyme.library.repositories.IBorrowedBookRepository.deleteById(..))")
    public void logAfterReturnABook(JoinPoint joinPoint) {
        logger.info("user returned a book at " + LocalDateTime.now());
    }
    @Before("execution(* com.codegyme.library.controllers.UserController.display(..))")
    public void incrementVisitorCount() {
        visitorCount++;
        logger.info("Visitor count: " + visitorCount);
    }
}
