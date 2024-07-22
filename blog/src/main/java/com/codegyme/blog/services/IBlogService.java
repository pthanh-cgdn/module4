package com.codegyme.blog.services;

import com.codegyme.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    public boolean save(Blog blog);

    public Blog findBlogById(int blogId);

    public void remove(Blog blog);

    public boolean editBlog(Blog blog);

    public Page<Blog> findAll(Pageable pageable);

    public Page<Blog> findByCategoryName(Pageable pageable, String category);

    Page<Blog> findAllByName(Pageable pageable, String searchByName);
}
