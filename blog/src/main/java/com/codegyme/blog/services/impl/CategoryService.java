package com.codegyme.blog.services.impl;

import com.codegyme.blog.models.Category;
import com.codegyme.blog.repositories.ICategoryRepository;
import com.codegyme.blog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int i) {
        return categoryRepository.findById(i).orElse(null);
    }
}
