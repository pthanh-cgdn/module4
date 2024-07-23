package com.codegyme.blog.services;

import com.codegyme.blog.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(int i);
}
