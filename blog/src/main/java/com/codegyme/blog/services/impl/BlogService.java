package com.codegyme.blog.services.impl;

import com.codegyme.blog.models.Blog;
import com.codegyme.blog.repositories.IBlogRepository;
import com.codegyme.blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    public boolean save(Blog blog) {
        blog.setCreatedAt(LocalDateTime.now());
        return blogRepository.save(blog) != null;
    }

    public Blog findBlogById(int blogId) {
        return blogRepository.findById(blogId).orElse(null);
    }

    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

    public boolean editBlog(Blog blog) {
        return blogRepository.save(blog)!=null;
    }

    public Page<Blog> findAll(Pageable pageable) {
            return blogRepository.findAll(pageable);
    }


    @Override
    public Page<Blog> findByCategoryName(Pageable pageable, String category) {
        return blogRepository.findAllByCategoryNameOrderByCreatedAtDesc(pageable,category);
    }

    @Override
    public Page<Blog> findAllByName(Pageable pageable, String searchByName) {
        return blogRepository.findAllByNameContainingIgnoreCaseOrderByCreatedAtDesc(pageable,searchByName);
    }

//    public List<Product> sort(String sortBy) {
//        return productRepository.sortByName(sortBy);
//    }
}

