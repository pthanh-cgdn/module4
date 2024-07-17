package com.codegyme.product_management.repositories.impl;

import com.codegyme.product_management.models.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public boolean add(Product product) {
        boolean isAdded;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("INSERT INTO product_management.products (name, categoryName, manufacture, price) values (?,?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getCategoryName());
            preparedStatement.setString(3, product.getManufacture());
            preparedStatement.setInt(4, product.getPrice());
            isAdded = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    public Product findProductById(int productId) {
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("SELECT * FROM product_management.products WHERE id = ?");
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String categoryName = resultSet.getString("categoryName");
                String manufacture = resultSet.getString("manufacture");
                int price = resultSet.getInt("price");
                return new Product(id, name, categoryName, manufacture, price);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void remove(Product product) {
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("DELETE FROM product_management.products WHERE id = ?");
            preparedStatement.setInt(1, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean editProduct(Product product) {
        boolean isEdited;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("UPDATE product_management.products SET name=?, categoryName=?, manufacture=?, price=? WHERE id = ?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getCategoryName());
            preparedStatement.setString(3, product.getManufacture());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setInt(5, product.getId());
            isEdited = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isEdited;
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("SELECT * FROM product_management.products");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String categoryName = resultSet.getString("categoryName");
                String manufacture = resultSet.getString("manufacture");
                int price = resultSet.getInt("price");
                products.add(new Product(id, name, categoryName, manufacture, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public List<Product> search(String searchContent) {
        List<Product> searchedProduct = new ArrayList<>();
        List<Product> products = getAll();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(searchContent.toLowerCase())) {
                searchedProduct.add(product);
            }
        }
        return searchedProduct;
    }

    public List<Product> sort(String sortBy) {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("SELECT * FROM product_management.products ORDER BY " + sortBy);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String categoryName = resultSet.getString("categoryName");
                String manufacture = resultSet.getString("manufacture");
                int price = resultSet.getInt("price");
                products.add(new Product(id, name, categoryName, manufacture, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}


