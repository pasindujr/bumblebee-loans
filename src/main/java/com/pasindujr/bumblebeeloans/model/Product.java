package com.pasindujr.bumblebeeloans.model;

public class Product {
	
	private int productCode;
	private String name;
	private double price;
	
	public Product(int productCode, String name, double price) {
		this.productCode = productCode;
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Product() {
		
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}	

}
