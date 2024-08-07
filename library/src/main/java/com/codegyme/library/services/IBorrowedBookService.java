package com.codegyme.library.services;

import com.codegyme.library.models.BorrowedBook;

public interface IBorrowedBookService {
    BorrowedBook save(BorrowedBook borrowedBook);

    boolean returnBook(BorrowedBook borrowedBook);

    BorrowedBook findById(Long borrowedKey);
}
