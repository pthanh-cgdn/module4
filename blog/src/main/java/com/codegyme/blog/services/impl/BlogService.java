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
    public List<Blog> findAll() {
        return blogRepository.findAllOrderByCreatedAtDesc();
    }


    @Override
    public Page<Blog> findByCategoryId(int categoryId,Pageable pageable) {
        return blogRepository.findAllByCategoryIdOrderByCreatedAtDesc (categoryId,pageable);
    }

    @Override
    public Page<Blog> findAllByName(String searchByName,Pageable pageable) {
        return blogRepository.findAllByNameContainingIgnoreCaseOrderByCreatedAtDesc(searchByName,pageable);
    }

    @Override
    public List<Blog> findAllByName(String searchByName) {
        return blogRepository.findAllByNameContainingIgnoreCaseOrderByCreatedAtDesc(searchByName);
    }

    @Override
    public Page<Blog> findByCategory(String category, Pageable pageable) {
        return blogRepository.findAllByCategoryNameOrderByCreatedAtDesc(category,pageable);
    }

//    public List<Product> sort(String sortBy) {
//        return productRepository.sortByName(sortBy);
//    }
}

