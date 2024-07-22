package com.codegyme.blog.repositories;

import com.codegyme.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
//    @Query(nativeQuery = true, value = "select * from blogs as s where s.name like :name")
//    List<Blog> findAllByNameContainingIgnoreCase(@Param("name") String name);
//    Page<Blog> findAllByNameContainingIgnoreCase(Pageable pageable,String name);
//    List<Blog> sortByName(String name);
    Page<Blog> findAllByOrderByCreatedAtDesc(Pageable pageable);
    List<Blog> findAllByOrderByCreatedAtDesc();
    Page<Blog> findAllByCategoryNameOrderByCreatedAtDesc(Pageable pageable,String categoryName);

    Page<Blog> findAllByNameContainingIgnoreCaseOrderByCreatedAtDesc(Pageable pageable, String searchByName);
}
