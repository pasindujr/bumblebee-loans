package com.pasindujr.bumblebeeloans.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectorImpl implements DbConnector {

	
	public Connection getDbConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/icbt_test";
		String userName = "pasindu";
		String password = "";
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		return connection;
	}

	
}
