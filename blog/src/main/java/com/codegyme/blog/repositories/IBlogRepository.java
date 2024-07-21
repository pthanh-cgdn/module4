package com.codegyme.blog.repositories;

import com.codegyme.blog.models.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByNameContainingIgnoreCase(String name);
//    List<Blog> sortByName(String name);
    List<Blog> findAllByOrderByCreatedAtDesc(Pageable pageable);
    List<Blog> findAllByOrderByCreatedAtDesc();
    List<Blog> findAllByCategoryNameOrderByCreatedAtDesc(String categoryName);
}
