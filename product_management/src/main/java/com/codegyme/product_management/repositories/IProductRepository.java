package com.codegyme.product_management.repositories;

import com.codegyme.product_management.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductRepository {
    public boolean add(Product product);
    public Product findProductById(int productId);
    public void remove(Product product);
    public boolean editProduct(Product product);
    public List<Product> getAll();
    public List<Product> search(String searchContent);
    public List<Product> sort(String sortBy);
}
