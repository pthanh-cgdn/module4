package com.codegyme.library.repositories;

import com.codegyme.library.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAllByTitleContaining(String bookName, Pageable pageable);
}
