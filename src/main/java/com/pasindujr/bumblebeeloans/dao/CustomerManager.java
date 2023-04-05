package com.pasindujr.bumblebeeloans.dao;

import com.pasindujr.bumblebeeloans.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

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
        DbConnector connector = getDbConnector();
        return connector.getDbConnection();
    }

    public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {

        Connection connection = getConncetion();

        String query = "INSERT INTO customer (name, dob, loan_balance, installment_plan) VALUES (?, ?,?,?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getDob());
        ps.setString(3, customer.getLoanBalance());
        ps.setString(4, customer.getInstallmentPlan());

        int result = ps.executeUpdate();

        ps.close();
        connection.close();

        return result > 0;
    }

    public Customer getSpecificCustomer(int customerId) throws ClassNotFoundException, SQLException {

        Connection connection = getConncetion();

        String query = "SELECT * FROM customer WHERE customer_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, customerId);

        ResultSet rs = ps.executeQuery();
        Customer customer = new Customer();
        while (rs.next()) {
            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setName(rs.getString("name"));
            customer.setDob(rs.getString("dob"));
            customer.setLoanBalance(rs.getString("loan_balance"));
            customer.setUsedAmount(rs.getString("used_amount"));
            customer.setInstallmentPlan(rs.getString("installment_plan"));
        }

        ps.close();
        connection.close();
        return customer;
    }

    public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {

        Connection connection = getConncetion();

        String query = "SELECT * FROM CUSTOMER";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        List<Customer> customerList = new ArrayList<Customer>();

        while (rs.next()) {

            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setName(rs.getString("name"));
            customer.setDob(rs.getString("dob"));
            customer.setLoanBalance(rs.getString("loan_balance"));
            customer.setUsedAmount(rs.getString("used_amount"));
            customer.setInstallmentPlan(rs.getString("installment_plan"));

            customerList.add(customer);
        }

        st.close();
        connection.close();
        return customerList;
    }

    public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {

        Connection connection = getConncetion();

        String query = "UPDATE customer SET name = ?, dob = ?, loan_balance = ?, used_amount = ?, installment_plan = ?  WHERE customer_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getDob());
        ps.setString(3, customer.getLoanBalance());
        ps.setString(4, customer.getUsedAmount());
        ps.setString(5, customer.getInstallmentPlan());
        ps.setInt(6, customer.getCustomerId());

        int result = ps.executeUpdate();

        ps.close();
        connection.close();

        return result > 0;
    }

    public boolean deleteCustomer(int customerId) throws ClassNotFoundException, SQLException {

        Connection connection = getConncetion();

        String query = "DELETE FROM CUSTOMER WHERE cutomer_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, customerId);

        int result = ps.executeUpdate();

        ps.close();
        connection.close();

        return result > 0;
    }
}
