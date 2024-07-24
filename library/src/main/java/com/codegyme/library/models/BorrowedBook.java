package com.codegyme.library.models;

import jakarta.persistence.*;

@Entity(name="borrowed_book")
public class BorrowedBook {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;
    public BorrowedBook() {
    }

    public BorrowedBook(Long id, Book book) {
        this.id = id;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
