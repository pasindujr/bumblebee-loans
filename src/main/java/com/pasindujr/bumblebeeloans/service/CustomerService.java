package com.pasindujr.bumblebeeloans.service;

import com.pasindujr.bumblebeeloans.dao.CustomerManager;
import com.pasindujr.bumblebeeloans.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {

    private static CustomerService customerServiceObj;

    private CustomerService() {

    }

    public static synchronized CustomerService getCustomerServiceInstance() {

        if (customerServiceObj == null) {
            customerServiceObj = new CustomerService();
        }

        return customerServiceObj;
    }

    private CustomerManager getCustomerManager() {
        return new CustomerManager();
    }

    //services---------------------------
    public boolean registerCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        return getCustomerManager().addCustomer(customer);
    }

    public Customer getSpecificCustomer(int customerId) throws ClassNotFoundException, SQLException {
        return getCustomerManager().getSpecificCustomer(customerId);
    }

    public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        return getCustomerManager().getAllCustomers();
    }

    public boolean editTheCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        return getCustomerManager().updateCustomer(customer);
    }

    public boolean deleteTheCustomer(int customerId) throws ClassNotFoundException, SQLException {
        return getCustomerManager().deleteCustomer(customerId);
    }

}
