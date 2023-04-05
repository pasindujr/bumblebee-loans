package com.pasindujr.bumblebeeloans.dao;

import com.pasindujr.bumblebeeloans.model.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandManager {
	
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
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DbConnector connector =  getDbConnector();
		return connector.getDbConnection();
	}
		
	public boolean addBrand(Brand brand) throws ClassNotFoundException, SQLException {
				
		Connection connection = getConnection();
		
		String query = "INSERT INTO brand (name) VALUES (?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, brand.getName());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public Brand getSpecificBrand(int brandId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM brand WHERE brand_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, brandId);
		
		ResultSet rs = ps.executeQuery();
		Brand brand = new Brand();
		while(rs.next()) {
			brand.setBrandId(rs.getInt("brand_id"));
			brand.setName(rs.getString("name"));
		}
		
		ps.close();
		connection.close();		
		return brand;
	}
	
	public List<Brand> getAllBrands() throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM BRAND";
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Brand> brandList = new ArrayList<Brand>();
		
		while(rs.next()) {
			
			Brand brand = new Brand();
			brand.setBrandId(rs.getInt("brand_id"));
			brand.setName(rs.getString("name"));
			
			brandList.add(brand);
		}
		
		st.close();
		connection.close();		
		return brandList;
	}
	
	public boolean updateBrand(Brand brand) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "UPDATE brand SET name = ? WHERE brand_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, brand.getName());
		ps.setInt(2, brand.getBrandId());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteBrand(int brandId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		String query = "DELETE FROM BRAND WHERE brand_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, brandId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;		
	}
}
