package com.codegyme.cart.services;

import com.codegyme.cart.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    Page<Product> findAllByName(String searchByName, Pageable pageable);
}
