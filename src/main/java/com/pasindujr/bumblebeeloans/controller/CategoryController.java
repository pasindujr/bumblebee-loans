package com.pasindujr.bumblebeeloans.controller;

import com.pasindujr.bumblebeeloans.model.Category;
import com.pasindujr.bumblebeeloans.service.CategoryService;

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


public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final CategoryService service;

	public CategoryController() {
		service = CategoryService.getCategoryServiceInstance();
	}
	
	//entry points of the controller----------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificCategory(request, response);
		}
		else {
			searchAllCategories(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addCategory(request, response);
		}
		else if(type != null && type.equals("update")) {
			updateCategory(request, response);
		}
		else if(type != null && type.equals("delete")) {
			deleteCategory(request, response);
		}		
		
	}
	
	
	//private methods------------
	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = null;
		
		String categoryName = request.getParameter("categoryName");
		
		Category category = new Category(categoryName);
		try {
			
			boolean result = service.registerCategory(category);
			if(result) {
				message = "The category has been successfully added! Category Name: " + categoryName;
			}
			else {
				message = "The category has been failed to add! Category Name: " + categoryName;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);		
		RequestDispatcher rd = request.getRequestDispatcher("category-register.jsp");
		rd.forward(request, response);

		message = null;
		
	}
	
	private void searchSpecificCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = null;
		Category category = new Category();
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		try {
			category = service.getSpecificCategory(categoryId);
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("category", category);
		
		RequestDispatcher rd = request.getRequestDispatcher("category-search-and-update.jsp");
		rd.forward(request, response);

		message = null;
	}
	
	private void searchAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = null;
		List<Category> categoryList;
		
		try {
			
			categoryList = service.getAllCategories();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			categoryList = new ArrayList<Category>();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("categoryList", categoryList);
		
		RequestDispatcher rd = request.getRequestDispatcher("category-welcome.jsp");
		rd.forward(request, response);

		message = null;
	}
	
	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String message = null;
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("categoryName");
		
		Category category = new Category(categoryId, categoryName);
		
		try {
			boolean result = service.editTheCategory(category);
			if(result) {
				message = "Category has been successfully updated! Category Code: " + category.getCategoryId();
			}
			else {
				message = "Failed to update the category! Category Code: " + category.getCategoryId();
			}
			
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("category-search-and-update.jsp");
		rd.forward(request, response);

		message = null;
	}
	
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = null;
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		try {
			boolean result = service.deleteTheCategory(categoryId);
			
			if(result) {
				message = "The category has been successfully deleted! Category Code: " + categoryId;
			}
			else {
				message = "Failed to delete the category! Category Code: " + categoryId;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		response.sendRedirect("category");

		message = null;

	}

}
