package com.codegyme.product_management.models;

public class Product {
    private int id;
    private String name;
    private String categoryName;
    private String manufacture;
    private int price;

    public Product() {
    }

    public Product(int id, String name, String categoryName, String manufacture, int price) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.manufacture = manufacture;
        this.price = price;
    }

    public Product(String name, String categoryName, String manufacture, int price) {
        this.name = name;
        this.categoryName = categoryName;
        this.manufacture = manufacture;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

