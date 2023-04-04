package com.pasindujr.bumblebeeloans.dao;

import com.pasindujr.bumblebeeloans.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
	
	/*
	 * 1. Import the Package
	 * 2. Load the Driver and Register It
	 * 3. Establish the Connection
	 * 4. Create the Statement
	 * 5. Execute the query
	 * 6. Process the response
	 * 7. Close the Connection (statement and the connection both need to be closed!) 
	 */
	
	public DbConnector getDbConnector() {
		
		DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl(); //if you can get this from config 
		return factory.getDbConnector();
	}
	
	private Connection getConncetion() throws ClassNotFoundException, SQLException {
		DbConnector connector =  getDbConnector();
		return connector.getDbConnection();
	}
		
	public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
				
		Connection connection = getConncetion();
		
		String query = "INSERT INTO product (name,price, brand, category) VALUES (?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setString(2, product.getPrice());
		ps.setString(3, product.getBrand());
		ps.setString(4, product.getCategory());

		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public Product getSpecificProduct(int productId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();
		
		String query = "SELECT * FROM product WHERE product_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, productId);
		
		ResultSet rs = ps.executeQuery();
		Product product = new Product();
		while(rs.next()) {
			product.setProductId(rs.getInt("product_id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getString("price"));
			product.setBrand(rs.getString("brand"));
			product.setCategory(rs.getString("category"));
		}
		
		ps.close();
		connection.close();		
		return product;
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();	
		
		String query = "SELECT * FROM PRODUCT";
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Product> productList = new ArrayList<Product>();
		
		while(rs.next()) {
			
			Product product = new Product();
			product.setProductId(rs.getInt("product_id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getString("price"));
			product.setBrand(rs.getString("brand"));
			product.setCategory(rs.getString("category"));

			productList.add(product);
		}
		
		st.close();
		connection.close();		
		return productList;
	}
	
	public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();	
		
		String query = "UPDATE product SET name = ?, price = ?, brand = ?, category = ? WHERE product_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setString(2, product.getPrice());
		ps.setString(3, product.getCategory());
		ps.setString(4, product.getBrand());
		ps.setInt(5, product.getProductId());

		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteProduct(int productId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();
		
		String query = "DELETE FROM PRODUCT WHERE product_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, productId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;		
	}
}
