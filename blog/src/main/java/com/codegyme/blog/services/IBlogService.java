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

    public Page<Blog> findByCategoryId( int categoryId,Pageable pageable);

    Page<Blog> findAllByName( String searchByName,Pageable pageable);
}
