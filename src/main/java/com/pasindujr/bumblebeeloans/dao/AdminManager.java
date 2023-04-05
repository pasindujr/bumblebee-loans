package com.pasindujr.bumblebeeloans.dao;

import com.pasindujr.bumblebeeloans.model.Admin;

import java.io.IOException;
import java.sql.*;

public class AdminManager {

    public DbConnector getDbConnector() {

        DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl(); //if you can get this from config
        return factory.getDbConnector();
    }

    private Connection getConncetion() throws ClassNotFoundException, SQLException {
        DbConnector connector = getDbConnector();
        return connector.getDbConnection();
    }

    public Admin verifyLogin(String adminEmail, String adminPassword) throws ClassNotFoundException, SQLException, IOException {
        Connection connection = getConncetion();
        Admin admin = null;

        String query = "SELECT name FROM admin WHERE email=? AND password=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1, adminEmail);
        pst.setString(2, adminPassword);

        ResultSet rs = pst.executeQuery();

        //rs.next()=> If admin is present in the database
        if (rs.next()) {
            admin = new Admin();
            admin.setName(rs.getString("name"));
        }

        pst.close();
        connection.close();

        return admin;
    }
}
