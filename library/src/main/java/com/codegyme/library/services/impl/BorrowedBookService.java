package com.codegyme.library.services.impl;

import com.codegyme.library.models.Book;
import com.codegyme.library.models.BorrowedBook;
import com.codegyme.library.repositories.IBorrowedBookRepository;
import com.codegyme.library.services.IBookService;
import com.codegyme.library.services.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BorrowedBookService implements IBorrowedBookService {
    @Autowired
    IBorrowedBookRepository borrowedBookRepository;
    @Autowired
    IBookService bookService;
    @Override
    public BorrowedBook save(BorrowedBook borrowedBook) {
        Long id;
         do {
            id=ThreadLocalRandom.current().nextLong(10000,99999);
        } while (borrowedBookRepository.findById(id).isPresent());
        borrowedBook.setId(id);
        if(bookService.borrow(borrowedBook.getBook())) {
            borrowedBookRepository.save(borrowedBook);
            return borrowedBook;
        }
        return null;
    }

    @Override
    public boolean returnBook(BorrowedBook borrowedBook) {
       if(borrowedBook!=null){
           Book book = borrowedBook.getBook();
           bookService.returnBook(book);
           borrowedBookRepository.delete(borrowedBook);
           return true;
       }
       return false;
    }

    @Override
    public BorrowedBook findById(Long borrowedKey) {
        return borrowedBookRepository.findById(borrowedKey).orElse(null);
    }
}
