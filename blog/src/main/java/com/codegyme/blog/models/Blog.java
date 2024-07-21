package com.codegyme.blog.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="categoryName")
    private String categoryName;
    @Column(name="author")
    private String author;
    @Column(name="description", columnDefinition = "TEXT")
    private String description;
    @Column(name="content", columnDefinition = "LONGTEXT")
    private String content;
    @CreatedDate
    @Column(name="created_at", updatable=false)
    private LocalDateTime createdAt;
    public Blog() {
    }

    public Blog(String name, String categoryName, String author, String description, String content) {
        this.name = name;
        this.categoryName = categoryName;
        this.author = author;
        this.description = description;
        this.content = content;
    }

    public Blog(int id, String name, String categoryName, String author, String description, String content) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.author = author;
        this.description = description;
        this.content = content;
    }

    public Blog(int id, String name, String categoryName, String author, String description, String content, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.author = author;
        this.description = description;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

