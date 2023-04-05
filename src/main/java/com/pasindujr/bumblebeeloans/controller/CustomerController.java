package com.pasindujr.bumblebeeloans.controller;

import com.pasindujr.bumblebeeloans.model.Customer;
import com.pasindujr.bumblebeeloans.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final CustomerService service;

    public CustomerController() {
        service = CustomerService.getCustomerServiceInstance();
    }

    //entry points of the controller----------------------------
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");

        if (type != null && type.equals("specific")) {
            searchSpecificCustomer(request, response);
        } else {
            searchAllCustomers(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");

        if (type != null && type.equals("add")) {
            addCustomer(request, response);
        } else if (type != null && type.equals("update")) {
            updateCustomer(request, response);
        } else if (type != null && type.equals("delete")) {
            deleteCustomer(request, response);
        }

    }


    //private methods------------
    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;

        String customerName = request.getParameter("customerName");
        String dob = request.getParameter("dob");
        String loanBalance = request.getParameter("loanBalance");
        String usedAmount = request.getParameter("usedAmount");
        String installmentPlan = request.getParameter("installmentPlan");

        Customer customer = new Customer(customerName, dob, loanBalance, usedAmount, installmentPlan);
        try {

            boolean result = service.registerCustomer(customer);
            if (result) {
                message = "The customer has been successfully added! Customer Name: " + customerName;
            } else {
                message = "The customer has been failed to add! Customer Name: " + customerName;
            }

        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("customer-register.jsp");
        rd.forward(request, response);

        message = null;

    }

    private void searchSpecificCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        Customer customer = new Customer();

        int customerId = Integer.parseInt(request.getParameter("customerId"));

        try {
            customer = service.getSpecificCustomer(customerId);
        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        request.setAttribute("customer", customer);

        RequestDispatcher rd = request.getRequestDispatcher("customer-search-and-update.jsp");
        rd.forward(request, response);

        message = null;
    }

    private void searchAllCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        List<Customer> customerList;

        try {

            customerList = service.getAllCustomers();
        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
            customerList = new ArrayList<Customer>();
        }

        request.setAttribute("message", message);
        request.setAttribute("customerList", customerList);

        RequestDispatcher rd = request.getRequestDispatcher("customer-welcome.jsp");
        rd.forward(request, response);

        message = null;
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;

        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("name");
        String dob = request.getParameter("dob");
        String loanBalance = request.getParameter("loanBalance");
        String usedAmount = request.getParameter("usedAmount");
        String installmentPlan = request.getParameter("installmentPlan");

        Customer customer = new Customer(customerId, customerName, dob, loanBalance, usedAmount, installmentPlan);

        try {
            boolean result = service.editTheCustomer(customer);
            if (result) {
                message = "Customer has been successfully updated! Customer Code: " + customer.getCustomerId();
            } else {
                message = "Failed to update the customer! Customer Code: " + customer.getCustomerId();
            }

        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("customer-search-and-update.jsp");
        rd.forward(request, response);

        message = null;
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String message = null;

        int customerId = Integer.parseInt(request.getParameter("customerId"));

        try {
            boolean result = service.deleteTheCustomer(customerId);

            if (result) {
                message = "The customer has been successfully deleted! Customer Code: " + customerId;
            } else {
                message = "Failed to delete the customer! Customer Code: " + customerId;
            }

        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        response.sendRedirect("customer");

        message = null;

    }

}
