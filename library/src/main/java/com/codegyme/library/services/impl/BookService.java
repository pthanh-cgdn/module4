package com.codegyme.library.services.impl;

import com.codegyme.library.models.Book;
import com.codegyme.library.models.BorrowedBook;
import com.codegyme.library.repositories.IBookRepository;
import com.codegyme.library.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public boolean borrow(Book book) {
       Book borrowedBook= bookRepository.findById(book.getId()).orElse(null);
       if(borrowedBook != null & borrowedBook.getQuantity()>0) {
               borrowedBook.setQuantity(borrowedBook.getQuantity() - 1);
               bookRepository.save(borrowedBook);
               return true;
       }
       return false;
    }

    @Override
    public void returnBook(Book book) {
        Book borrowedBook = bookRepository.findById(book.getId()).orElse(null);
        if (borrowedBook != null) {
            borrowedBook.setQuantity(borrowedBook.getQuantity() + 1);
            bookRepository.save(borrowedBook);
        }
    }

    @Override
    public Page<Book> findAllByName(String bookName, Pageable pageable) {
        return bookRepository.findAllByTitleContaining(bookName, pageable);
    }
}
