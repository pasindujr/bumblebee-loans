package com.pasindujr.bumblebeeloans.controller;

import com.pasindujr.bumblebeeloans.model.Product;
import com.pasindujr.bumblebeeloans.model.Stock;
import com.pasindujr.bumblebeeloans.model.Stock;
import com.pasindujr.bumblebeeloans.service.BrandService;
import com.pasindujr.bumblebeeloans.service.CategoryService;
import com.pasindujr.bumblebeeloans.service.ProductService;
import com.pasindujr.bumblebeeloans.service.StockService;

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


public class StockController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final StockService service;
    private final ProductService productService;

    public StockController() {
        service = StockService.getStockServiceInstance();
        productService = ProductService.getProductServiceInstance();
    }

    //entry points of the controller----------------------------
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");

        if (type != null && type.equals("specific")) {
            searchSpecificStock(request, response);
        } else if (type != null && type.equals("loadStockCreateForm")) {
            loadStockCreateForm(request, response);
        }
        {
            searchAllStocks(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");

        if (type != null && type.equals("add")) {
            addStock(request, response);
        } else if (type != null && type.equals("update")) {
            updateStock(request, response);
        } else if (type != null && type.equals("delete")) {
            deleteStock(request, response);
        }

    }


    //private methods------------
    private void addStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        List<Product> productList = null;

        String price = request.getParameter("product");
        String brand = request.getParameter("quantity");

        Stock stock = new Stock(price, brand);
        try {
            productList = productService.getAllProducts();

            boolean result = service.registerStock(stock);
            if (result) {
                message = "The stock has been successfully added!";
            } else {
                message = "The stock has been failed to add!";
            }

        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        request.setAttribute("productList", productList);
        RequestDispatcher rd = request.getRequestDispatcher("stock-register.jsp");
        rd.forward(request, response);

        message = null;

    }

    private void searchSpecificStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        Stock stock = new Stock();
        List<Product> productList = null;

        int stockId = Integer.parseInt(request.getParameter("stockId"));

        try {
            stock = service.getSpecificStock(stockId);
            productList = productService.getAllProducts();
        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        request.setAttribute("productList", productList);
        request.setAttribute("stock", stock);

        RequestDispatcher rd = request.getRequestDispatcher("stock-search-and-update.jsp");
        rd.forward(request, response);

        message = null;
    }

    private void searchAllStocks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        List<Stock> stockList;

        try {

            stockList = service.getAllStocks();
        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
            stockList = new ArrayList<Stock>();
        }

        request.setAttribute("message", message);
        request.setAttribute("stockList", stockList);

        RequestDispatcher rd = request.getRequestDispatcher("stock-welcome.jsp");
        rd.forward(request, response);

        message = null;
    }

    private void updateStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;

        int stockId = Integer.parseInt(request.getParameter("stockId"));
        String product = request.getParameter("product");
        String quantity = request.getParameter("quantity");

        Stock stock = new Stock(stockId, product, quantity);

        try {
            boolean result = service.editTheStock(stock);
            if (result) {
                message = "Stock has been successfully updated! stock Code: " + stock.getStockId();
            } else {
                message = "Failed to update the stock! Stock Code: " + stock.getStockId();
            }

        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("stock-search-and-update.jsp");
        rd.forward(request, response);

        message = null;
    }

    private void deleteStock(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String message = null;

        int stockId = Integer.parseInt(request.getParameter("stockId"));

        try {
            boolean result = service.deleteTheStock(stockId);

            if (result) {
                message = "The stock has been successfully deleted! Product Code: " + stockId;
            } else {
                message = "Failed to delete the stock! Stock Code: " + stockId;
            }

        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        response.sendRedirect("stock");

        message = null;

    }

    private void loadStockCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        List<Product> productList = null;

        try {
            productList = productService.getAllProducts();


        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        request.setAttribute("productList", productList);
        RequestDispatcher rd = request.getRequestDispatcher("stock-register.jsp");
        rd.forward(request, response);

        message = null;

    }

}
