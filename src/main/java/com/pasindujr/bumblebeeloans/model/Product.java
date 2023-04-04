package com.pasindujr.bumblebeeloans.model;

public class Product {

    private int productId;
    private String name;
    private String price;
    private String brand;
    private String category;


    public Product(int productId, String name, String price, String brand, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
    }

    public Product(String name, String price, String brand, String category) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
