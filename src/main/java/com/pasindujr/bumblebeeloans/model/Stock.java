package com.pasindujr.bumblebeeloans.model;

public class Stock {

    private int stockId;
    private String product;
    private String quantity;

    public Stock(int stockId, String product, String quantity) {
        this.stockId = stockId;
        this.product = product;
        this.quantity = quantity;
    }

    public Stock(String product, String quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Stock() {

    }

    public int getStockId() {
        return stockId;
    }

    public String getProduct() {
        return product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
