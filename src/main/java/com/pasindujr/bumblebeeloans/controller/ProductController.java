package com.pasindujr.bumblebeeloans.controller;

import com.pasindujr.bumblebeeloans.model.Brand;
import com.pasindujr.bumblebeeloans.model.Category;
import com.pasindujr.bumblebeeloans.model.Product;
import com.pasindujr.bumblebeeloans.service.BrandService;
import com.pasindujr.bumblebeeloans.service.CategoryService;
import com.pasindujr.bumblebeeloans.service.ProductService;

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


public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ProductService service;
    private final BrandService brandService;
    private final CategoryService categoryService;

    public ProductController() {
        service = ProductService.getProductServiceInstance();
        brandService = BrandService.getBrandServiceInstance();
        categoryService = CategoryService.getCategoryServiceInstance();
    }

    //entry points of the controller----------------------------
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");

        if (type != null && type.equals("specific")) {
            searchSpecificProduct(request, response);
        } else if (type != null && type.equals("loadProductCreateForm")) {
            loadProductCreateForm(request, response);
        }
        {
            searchAllProducts(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");

        if (type != null && type.equals("add")) {
            addProduct(request, response);
        } else if (type != null && type.equals("update")) {
            updateProduct(request, response);
        } else if (type != null && type.equals("delete")) {
            deleteProduct(request, response);
        }

    }


    //private methods------------
    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        List<Brand> brandList = null;
        List<Category> categoryList = null;

        String productName = request.getParameter("productName");
        String price = request.getParameter("price");
        String brand = request.getParameter("brand");
        String category = request.getParameter("category");

        Product product = new Product(productName, price, brand, category);
        try {
            brandList = brandService.getAllBrands();
            categoryList = categoryService.getAllCategories();

            boolean result = service.registerProduct(product);
            if (result) {
                message = "The product has been successfully added! product Name: " + productName;
            } else {
                message = "The product has been failed to add! product Name: " + productName;
            }

        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        request.setAttribute("brandList", brandList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher rd = request.getRequestDispatcher("product-register.jsp");
        rd.forward(request, response);

        message = null;

    }

    private void searchSpecificProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        Product product = new Product();

        int productId = Integer.parseInt(request.getParameter("productId"));

        try {
            product = service.getSpecificProduct(productId);
        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        request.setAttribute("product", product);

        RequestDispatcher rd = request.getRequestDispatcher("product-search-and-update.jsp");
        rd.forward(request, response);

        message = null;
    }

    private void searchAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        List<Product> productList;

        try {

            productList = service.getAllProducts();
        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
            productList = new ArrayList<Product>();
        }

        request.setAttribute("message", message);
        request.setAttribute("productList", productList);

        RequestDispatcher rd = request.getRequestDispatcher("product-welcome.jsp");
        rd.forward(request, response);

        message = null;
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;

        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        String price = request.getParameter("price");
        String brand = request.getParameter("brand");
        String category = request.getParameter("category");

        Product product = new Product(productId, productName, price, brand, category);

        try {
            boolean result = service.editTheProduct(product);
            if (result) {
                message = "Product has been successfully updated! product Code: " + product.getProductId();
            } else {
                message = "Failed to update the product! Product Code: " + product.getProductId();
            }

        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("product-search-and-update.jsp");
        rd.forward(request, response);

        message = null;
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String message = null;

        int productId = Integer.parseInt(request.getParameter("productId"));

        try {
            boolean result = service.deleteTheProduct(productId);

            if (result) {
                message = "The product has been successfully deleted! Product Code: " + productId;
            } else {
                message = "Failed to delete the product! Product Code: " + productId;
            }

        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        response.sendRedirect("product");

        message = null;

    }

    private void loadProductCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        List<Brand> brandList = null;
        List<Category> categoryList = null;

        try {
            brandList = brandService.getAllBrands();
            categoryList = categoryService.getAllCategories();


        } catch (ClassNotFoundException | SQLException e) {

            message = e.getMessage();
        }

        request.setAttribute("message", message);
        request.setAttribute("brandList", brandList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher rd = request.getRequestDispatcher("product-register.jsp");
        rd.forward(request, response);

        message = null;

    }

}
