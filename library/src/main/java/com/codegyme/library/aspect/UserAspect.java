package com.codegyme.library.aspect;

import com.codegyme.library.models.BorrowedBook;
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
    @After(value = "execution(* com.codegyme.library.repositories.IBorrowedBookRepository.save(..))")
    public void logAfterBorrowABook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        BorrowedBook borrowedBook = (BorrowedBook) args[0];
        logger.info("user borrowed book "+borrowedBook.getBook().getTitle() + " at " + LocalDateTime.now());
    }
    @After("execution(* com.codegyme.library.repositories.IBorrowedBookRepository.delete(..))")
    public void logAfterReturnABook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        BorrowedBook borrowedBook = (BorrowedBook) args[0];
        logger.info("user return book "+borrowedBook.getBook().getTitle() + " at " + LocalDateTime.now());

    }
    @Before("execution(* com.codegyme.library.controllers.UserController.display(..))")
    public void incrementVisitorCount() {
        visitorCount++;
        logger.info("Visitor to homepage count: " + visitorCount);
    }
}
