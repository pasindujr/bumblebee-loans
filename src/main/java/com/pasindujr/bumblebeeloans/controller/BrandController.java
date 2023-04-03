package com.pasindujr.bumblebeeloans.controller;

import com.pasindujr.bumblebeeloans.model.Brand;
import com.pasindujr.bumblebeeloans.service.BrandService;

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


public class BrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final BrandService service;
	
	public BrandController() {
		service = BrandService.getBrandServiceInstance();
	}
	
	//entry points of the controller----------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("specific")) {
			searchSpecificBrand(request, response);
		}
		else {
			searchAllBrands(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("add")) {
			addBrand(request, response);
		}
		else if(type != null && type.equals("update")) {
			updateBrand(request, response);
		}
		else if(type != null && type.equals("delete")) {
			deleteBrand(request, response);
		}		
		
	}
	
	
	//private methods------------
	private void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = null;
		
		String brandName = request.getParameter("brandName");
		
		Brand brand = new Brand(brandName);
		try {
			
			boolean result = service.registerBrand(brand);
			if(result) {
				message = "The brand has been successfully added! Brand Name: " + brandName;
			}
			else {
				message = "The brand has been failed to add! brand Name: " + brandName;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);		
		RequestDispatcher rd = request.getRequestDispatcher("brand-register.jsp");
		rd.forward(request, response);

		message = null;
		
	}
	
	private void searchSpecificBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = null;
		Brand brand = new Brand();
		
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		
		try {
			brand = service.getSpecificBrand(brandId);
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("brand", brand);
		
		RequestDispatcher rd = request.getRequestDispatcher("brand-search-and-update.jsp");
		rd.forward(request, response);

		message = null;
	}
	
	private void searchAllBrands(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = null;
		List<Brand> brandList;
		
		try {
			
			brandList = service.getAllBrands();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			brandList = new ArrayList<Brand>();
		}
		
		request.setAttribute("message", message);
		request.setAttribute("brandList", brandList);
		
		RequestDispatcher rd = request.getRequestDispatcher("brand-welcome.jsp");
		rd.forward(request, response);

		message = null;
	}
	
	private void updateBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String message = null;
		
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		String brandName = request.getParameter("brandName");
		
		Brand brand = new Brand(brandId, brandName);
		
		try {
			boolean result = service.editTheBrand(brand);
			if(result) {
				message = "Brand has been successfully updated! Brand Code: " + brand.getBrandId();
			}
			else {
				message = "Failed to update the brand! Brand Code: " + brand.getBrandId();
			}
			
		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("brand-search-and-update.jsp");
		rd.forward(request, response);

		message = null;
	}
	
	private void deleteBrand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String message = null;
		
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		
		try {
			boolean result = service.deleteTheBrand(brandId);
			
			if(result) {
				message = "The brand has been successfully deleted! Brand Code: " + brandId;
			}
			else {
				message = "Failed to delete the brand! Brand Code: " + brandId;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		response.sendRedirect("brand");

		message = null;

	}

}
