package com.pasindujr.bumblebeeloans.service;

import com.pasindujr.bumblebeeloans.model.Admin;

import java.io.IOException;
import java.sql.SQLException;

public interface AdminService {
    public Admin verifyLogin(String adminEmail, String adminPassword) throws SQLException, ClassNotFoundException, IOException;

}
