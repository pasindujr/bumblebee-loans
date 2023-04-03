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
		
		String query = "INSERT INTO product (name, price) VALUES ( ?, ?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setDouble(2, product.getPrice());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public Product getSpecificProduct(int productCode) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();
		
		String query = "SELECT * FROM product WHERE product_code = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, productCode);
		
		ResultSet rs = ps.executeQuery();
		Product product = new Product();
		while(rs.next()) {
			product.setProductCode(rs.getInt("product_code"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
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
			product.setProductCode(rs.getInt("product_code"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
			
			productList.add(product);
		}
		
		st.close();
		connection.close();		
		return productList;
	}
	
	public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();	
		
		String query = "UPDATE product SET name = ?, price = ? WHERE product_code = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setDouble(2, product.getPrice());
		ps.setInt(3, product.getProductCode());		
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteProduct(int productCode) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();
		
		String query = "DELETE FROM PRODUCT WHERE product_code = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, productCode);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;		
	}
}
