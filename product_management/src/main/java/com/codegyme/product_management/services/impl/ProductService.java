package com.codegyme.product_management.services.impl;

import com.codegyme.product_management.models.Product;
import com.codegyme.product_management.repositories.impl.ProductRepository;
import com.codegyme.product_management.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    public boolean addProduct(Product product) {
        return productRepository.add(product);
    }

    public Product findProductById(int productId) {
        return productRepository.findProductById(productId);
    }

    public void remove(Product product) {
        productRepository.remove(product);
    }

    public boolean editProduct( Product product) {
        return productRepository.editProduct(product);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public List<Product> search(String searchContent) {
        return productRepository.search(searchContent);
    }

    public List<Product> sort(String sortBy) {
        return productRepository.sort(sortBy);
    }
}

