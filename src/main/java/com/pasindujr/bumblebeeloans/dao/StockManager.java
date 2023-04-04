package com.pasindujr.bumblebeeloans.dao;

import com.pasindujr.bumblebeeloans.model.Stock;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockManager {
	
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
		
	public boolean addStock(Stock stock) throws ClassNotFoundException, SQLException {
				
		Connection connection = getConncetion();
		
		String query = "INSERT INTO stock (product,quantity) VALUES (?,?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, stock.getProduct());
		ps.setString(2, stock.getQuantity());

		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public Stock getSpecificStock(int stockId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();
		
		String query = "SELECT * FROM stock WHERE stock_id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, stockId);
		
		ResultSet rs = ps.executeQuery();
		Stock stock = new Stock();
		while(rs.next()) {
			stock.setStockId(rs.getInt("stock_id"));
			stock.setProduct(rs.getString("product"));
			stock.setQuantity(rs.getString("quantity"));
		}
		
		ps.close();
		connection.close();		
		return stock;
	}
	
	public List<Stock> getAllStocks() throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();	
		
		String query = "SELECT * FROM STOCK";
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Stock> stockList = new ArrayList<Stock>();
		
		while(rs.next()) {
			
			Stock stock = new Stock();
			stock.setStockId(rs.getInt("stock_id"));
			stock.setProduct(rs.getString("product"));
			stock.setQuantity(rs.getString("quantity"));

			stockList.add(stock);
		}
		
		st.close();
		connection.close();		
		return stockList;
	}
	
	public boolean updateStock(Stock stock) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();	
		
		String query = "UPDATE stock SET product = ?, quantity = ? WHERE stock_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, stock.getProduct());
		ps.setString(2, stock.getQuantity());
		ps.setInt(3, stock.getStockId());

		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public boolean deleteStock(int stockId) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConncetion();
		
		String query = "DELETE FROM STOCK WHERE stock_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, stockId);
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;		
	}
}
