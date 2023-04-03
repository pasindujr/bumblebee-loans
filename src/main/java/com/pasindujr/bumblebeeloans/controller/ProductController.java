package com.pasindujr.bumblebeeloans.controller;

import com.pasindujr.bumblebeeloans.model.Product;
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
	
	public ProductController() {
		service = ProductService.getProductServiceInstance();
	}
	
	//entry points of the controller----------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificProduct(request, response);
		}
		else {
			searchAllProducts(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addProduct(request, response);
		}
		else if(type != null && type.equals("update")) {
			updateProduct(request, response);
		}
		else if(type != null && type.equals("delete")) {
			deleteProduct(request, response);
		}		
		
	}
	
	
	//private methods------------
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		String productName = request.getParameter("productName");
		double price = Double.parseDouble(request.getParameter("price"));
		
		Product product = new Product(productName, price);
		try {
			
			boolean result = service.registerProduct(product);
			if(result) {
				message = "The Product has been successfully added! Product Name: " + productName;
			}
			else {
				message = "The Product has been failed to add! Product Name: " + productName;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);		
		RequestDispatcher rd = request.getRequestDispatcher("brand-register-product.jsp");
		rd.forward(request, response);
		
	}
	
	private void searchSpecificProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";		
		Product product = new Product();
		
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		
		try {
			product = service.getSpecificProduct(productCode);
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("product", product);
		
		RequestDispatcher rd = request.getRequestDispatcher("brand-search-and-update.jsp");
		rd.forward(request, response);
	}
	
	private void searchAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		List<Product> productList;
		
		try {
			
			productList = service.getAllProducts();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			productList = new ArrayList<Product>();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("productList", productList);
		
		RequestDispatcher rd = request.getRequestDispatcher("brand-welcome.jsp");
		rd.forward(request, response);
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String message = "";
		
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		String productName = request.getParameter("productName");
		Double price = Double.parseDouble(request.getParameter("price"));
		
		Product product = new Product(productCode, productName, price);
		
		try {
			boolean result = service.editTheProduct(product);
			if(result) {
				message = "Product has been successfully updated! Product Code: " + product.getProductCode();
			}
			else {
				message = "Failed to update the product! Product Code: " + product.getProductCode();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("brand-search-and-update.jsp");
		rd.forward(request, response);
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = "";
		
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		
		try {
			boolean result = service.deleteTheProduct(productCode);
			
			if(result) {
				message = "The product has been successfully deleted! Product Code: " + productCode;
			}
			else {
				message = "Failed to delete the product! Product Code: " + productCode;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);		
		response.sendRedirect("brand");
		
	}

}
