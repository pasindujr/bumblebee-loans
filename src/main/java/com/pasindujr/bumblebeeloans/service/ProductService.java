package com.pasindujr.bumblebeeloans.service;

import com.pasindujr.bumblebeeloans.dao.ProductManager;
import com.pasindujr.bumblebeeloans.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

	private static ProductService productServiceObj;

	private ProductService() {

	}

	public static synchronized ProductService getProductServiceInstance() {

		if(productServiceObj == null) {
			productServiceObj = new ProductService();
		}

		return productServiceObj;
	}

	private ProductManager getProductManager() {
		return new ProductManager();
	}

	//services---------------------------
	public boolean registerProduct(Product product) throws ClassNotFoundException, SQLException {
		return getProductManager().addProduct(product);
	}

	public Product getSpecificProduct(int productId) throws ClassNotFoundException, SQLException {
		return getProductManager().getSpecificProduct(productId);
	}

	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		return getProductManager().getAllProducts();
	}

	public boolean editTheProduct(Product product) throws ClassNotFoundException, SQLException {
		return getProductManager().updateProduct(product);
	}

	public boolean deleteTheProduct(int productId) throws ClassNotFoundException, SQLException {
		return getProductManager().deleteProduct(productId);
	}

}
