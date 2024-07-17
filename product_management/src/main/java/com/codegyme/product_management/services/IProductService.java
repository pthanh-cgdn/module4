package com.codegyme.product_management.services;

import com.codegyme.product_management.models.Product;

import java.util.List;

public interface IProductService {
    public boolean addProduct(Product product);

    public Product findProductById(int productId);

    public void remove(Product product);

    public boolean editProduct(Product product);

    public List<Product> getAll() ;

    public List<Product> search(String searchContent) ;

    public List<Product> sort(String sortBy) ;
}
