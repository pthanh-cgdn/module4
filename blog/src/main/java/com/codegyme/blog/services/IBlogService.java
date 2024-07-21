package com.codegyme.blog.services;

import com.codegyme.blog.models.Blog;

import java.util.List;

public interface IBlogService {
    public boolean save(Blog blog);

    public Blog findBlogById(int blogId);

    public void remove(Blog blog);

    public boolean editBlog(Blog blog);

    public List<Blog> findAll() ;

    public List<Blog> search(String searchContent) ;

    public List<Blog> findByCategoryName(String category);

//    public List<Product> sort(String sortBy) ;
}
