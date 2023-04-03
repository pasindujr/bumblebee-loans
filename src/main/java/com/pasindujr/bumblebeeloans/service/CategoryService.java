package com.pasindujr.bumblebeeloans.service;

import com.pasindujr.bumblebeeloans.dao.CategoryManager;
import com.pasindujr.bumblebeeloans.model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {

	private static CategoryService categoryServiceObj;

	private CategoryService() {

	}

	public static synchronized CategoryService getCategoryServiceInstance() {

		if(categoryServiceObj == null) {
			categoryServiceObj = new CategoryService();
		}

		return categoryServiceObj;
	}

	private CategoryManager getCategoryManager() {
		return new CategoryManager();
	}

	//services---------------------------
	public boolean registerCategory(Category category) throws ClassNotFoundException, SQLException {
		return getCategoryManager().addCategory(category);
	}

	public Category getSpecificCategory(int categoryId) throws ClassNotFoundException, SQLException {
		return getCategoryManager().getSpecificCategory(categoryId);
	}

	public List<Category> getAllCategories() throws ClassNotFoundException, SQLException {
		return getCategoryManager().getAllCategories();
	}

	public boolean editTheCategory(Category category) throws ClassNotFoundException, SQLException {
		return getCategoryManager().updateCategory(category);
	}

	public boolean deleteTheCategory(int categoryId) throws ClassNotFoundException, SQLException {
		return getCategoryManager().deleteCategory(categoryId);
	}

}
