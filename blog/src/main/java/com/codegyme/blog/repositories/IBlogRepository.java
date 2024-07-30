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
    Page<Blog> findAllByCategoryNameOrderByCreatedAtDesc(String categoryName,Pageable pageable);
    Page<Blog> findAllByNameContainingIgnoreCaseOrderByCreatedAtDesc( String searchByName,Pageable pageable);
    List<Blog> findAllByNameContainingIgnoreCaseOrderByCreatedAtDesc(String searchByName);
    @Query(nativeQuery = true, value = "select * from blogs as s order by s.created_at desc")
    List<Blog> findAllOrderByCreatedAtDesc();
    @Query(nativeQuery = true, value = "select * from blogs as s where s.category_id = :categoryId order by s.created_at desc")
    Page<Blog> findAllByCategoryIdOrderByCreatedAtDesc(@Param("categoryId")int categoryId, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from blogs as s order by s.created_at desc limit :records ")
    List<Blog> findBlog(@Param("records") int records);
}
