package com.codegyme.library.aspect;

import com.codegyme.library.models.BorrowedBook;
import jakarta.validation.Valid;
import lombok.Value;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

@Component
@Aspect
public class UserAspect {
    private static int visitorCount;
    private static String URL_LOG_BOOK="/Users/tphan/codegym/codegyme-java/module4/library/src/main/java/com/codegyme/library/file/Log_action.txt";
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @After(value = "execution(* com.codegyme.library.repositories.IBorrowedBookRepository.save(..))")
    public void logAfterBorrowABook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        BorrowedBook borrowedBook = (BorrowedBook) args[0];
        File file = new File(URL_LOG_BOOK);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String log = "user borrowed book "+borrowedBook.getBook().getTitle() + " at " + LocalDateTime.now() + "\n";
            bufferedWriter.write(log);
            bufferedWriter.flush();
        } catch (Exception e) {
            logger.error("file writing errors", e);
        }
        logger.info("user borrowed book "+borrowedBook.getBook().getTitle() + " at " + LocalDateTime.now());
    }
    @After("execution(* com.codegyme.library.repositories.IBorrowedBookRepository.delete(..))")
    public void logAfterReturnABook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        BorrowedBook borrowedBook = (BorrowedBook) args[0];
        File file = new File(URL_LOG_BOOK);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String log = "user return book "+borrowedBook.getBook().getTitle() + " at " + LocalDateTime.now() + "\n";
            bufferedWriter.write(log);
            bufferedWriter.flush();
        } catch (Exception e) {
            logger.error("file writing errors", e);
        }
        logger.info("user return book "+borrowedBook.getBook().getTitle() + " at " + LocalDateTime.now());

    }

    @AfterThrowing(value = "execution(* com.codegyme.library.controllers.UserController.*(..))", throwing = "ex")
    public void logVisitorsAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        visitorCount++;

        File file = new File(URL_LOG_BOOK);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String log = "user access feature at " + LocalDateTime.now() + ", Total visitor: " + visitorCount + "\n";
            bufferedWriter.write(log);
            bufferedWriter.flush();
        } catch (Exception e) {
            logger.error("Lỗi ghi file", e);
        }
    }
}
