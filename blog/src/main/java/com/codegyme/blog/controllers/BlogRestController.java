package com.codegyme.blog.controllers;

import com.codegyme.blog.models.Blog;
import com.codegyme.blog.models.Category;
import com.codegyme.blog.services.IBlogService;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public ResponseEntity<?> getAllBlog() {
        Page<Blog> blogs = blogService.findAll(Pageable.ofSize(5));
        return new ResponseEntity<>(blogs, HttpStatus.BAD_REQUEST);
    }
    @PostMapping
    public ResponseEntity<?> createBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getBlogCategory(@PathVariable int id) {
        Page<Blog> blogs = blogService.findByCategoryId(id,Pageable.ofSize(5));
        return new ResponseEntity<>(blogs, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable int id) {
        Blog blog = blogService.findBlogById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog) {
        if(blogService.findBlogById(blog.getId()) != null) {
            blogService.save(blog);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteBlog(@RequestBody Blog blog) {
        if(blogService.findBlogById(blog.getId()) != null) {
            blogService.remove(blog);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
