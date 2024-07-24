package com.codegyme.library.repositories;

import com.codegyme.library.models.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
}
