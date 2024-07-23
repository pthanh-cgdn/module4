package com.codegyme.blog.repositories;

import com.codegyme.blog.models.Blog;
import com.codegyme.blog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
