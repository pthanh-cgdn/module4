package com.codegyme.cart.services.impl;

import com.codegyme.cart.models.Product;
import com.codegyme.cart.repositories.IProductRepository;
import com.codegyme.cart.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> findAllByName(String searchByName, Pageable pageable) {
        return productRepository.findAllByNameContaining(searchByName, pageable);
    }
}
