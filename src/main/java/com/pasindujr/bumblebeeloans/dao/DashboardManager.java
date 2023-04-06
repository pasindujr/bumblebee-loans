package com.pasindujr.bumblebeeloans.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DashboardManager {
    public static DbConnector getDbConnector() {

        DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl(); //if you can get this from config
        return factory.getDbConnector();
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        DbConnector connector =  getDbConnector();
        return connector.getDbConnection();
    }
}
