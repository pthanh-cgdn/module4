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
    private IBlogRepository productRepository;
    public boolean save(Blog blog) {
        blog.setCreatedAt(LocalDateTime.now());
        return productRepository.save(blog) != null;
    }

    public Blog findBlogById(int blogId) {
        return productRepository.findById(blogId).orElse(null);
    }

    public void remove(Blog blog) {
        productRepository.delete(blog);
    }

    public boolean editBlog(Blog blog) {
        return productRepository.save(blog)!=null;
    }

    public List<Blog> findAll() {

//        Pageable pageable = PageRequest.of(0, 2);
//        List<Blog> pagedData = productRepository.findAllByOrderByCreatedAtDesc(pageable);
//        return pagedData;
        return productRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Blog> search(String searchContent) {
        return productRepository.findAllByNameContainingIgnoreCase(searchContent);
    }

    @Override
    public List<Blog> findByCategoryName(String category) {
        return productRepository.findAllByCategoryNameOrderByCreatedAtDesc(category);
    }

//    public List<Product> sort(String sortBy) {
//        return productRepository.sortByName(sortBy);
//    }
}

