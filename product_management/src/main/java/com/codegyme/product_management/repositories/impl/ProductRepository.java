package com.codegyme.product_management.repositories.impl;

import com.codegyme.product_management.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository(value = "productRepository")
public class ProductRepository {

    public boolean add(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
        return true;
    }

    public Product findProductById(int productId) {
         return BaseRepository.entityManager.find(Product.class, productId);
    }

    public void remove(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(product);
        transaction.commit();
    }

    public boolean editProduct(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
        return true;
    }

    public List<Product> getAll() {
        List<Product> products = BaseRepository.entityManager.createQuery("from products",Product.class).getResultList();
        return products;
    }

    public List<Product> search(String searchContent) {
        List<Product> searchedProduct = BaseRepository.entityManager.createQuery("select s from products s where name LIKE :name", Product.class).setParameter("name", '%'+searchContent+'%').getResultList();
        return searchedProduct;
    }

    public List<Product> sort(String sortBy) {
        List<Product> products = BaseRepository.entityManager.createQuery("select s from products s order by "+sortBy, Product.class).getResultList();
        return products;
    }
}


