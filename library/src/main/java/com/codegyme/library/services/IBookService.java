package com.codegyme.library.services;

import com.codegyme.library.models.Book;
import com.codegyme.library.models.BorrowedBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    Book findById(Long id);

    boolean borrow(Book book);

    void returnBook(Book book);

    Page<Book> findAllByName(String bookName, Pageable pageable);
}
