package com.pasindujr.bumblebeeloans.dao;

public class MySqlDbConnectorFactoryImpl implements DbConnectorFactory{

	@Override
	public DbConnector getDbConnector() {
		
		return new MySqlConnectorImpl();
	}
	
}
