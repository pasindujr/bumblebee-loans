package com.pasindujr.bumblebeeloans.dao;

import com.pasindujr.bumblebeeloans.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
	
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
		
	public boolean addCategory(Category category) throws ClassNotFoundException, SQLException {
				
		Connection connection = getConncetion();
		
		String query = "INSERT INTO category (name) VALUES (?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, category.getName());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public Category getSpecificCategory(int categoryId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();
		
		String query = "SELECT * FROM category WHERE category_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, categoryId);
		
		ResultSet rs = ps.executeQuery();
		Category category = new Category();
		while(rs.next()) {
			category.setCategoryId(rs.getInt("category_id"));
			category.setName(rs.getString("name"));
		}
		
		ps.close();
		connection.close();		
		return category;
	}
	
	public List<Category> getAllCategories() throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();	
		
		String query = "SELECT * FROM CATEGORY";
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Category> categoryList = new ArrayList<Category>();
		
		while(rs.next()) {
			
			Category category = new Category();
			category.setCategoryId(rs.getInt("category_id"));
			category.setName(rs.getString("name"));
			
			categoryList.add(category);
		}
		
		st.close();
		connection.close();		
		return categoryList;
	}
	
	public boolean updateCategory(Category category) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();	
		
		String query = "UPDATE category SET name = ? WHERE category_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, category.getName());
		ps.setInt(2, category.getCategoryId());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteCategory(int categoryId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();
		
		String query = "DELETE FROM CATEGORY WHERE category_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, categoryId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;		
	}
}
