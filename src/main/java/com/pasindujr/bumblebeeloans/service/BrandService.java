package com.pasindujr.bumblebeeloans.service;

import com.pasindujr.bumblebeeloans.dao.BrandManager;
import com.pasindujr.bumblebeeloans.model.Brand;

import java.sql.SQLException;
import java.util.List;

public class BrandService {
	
	private static BrandService brandServiceObj;

	private BrandService() {
		
	}
	
	public static synchronized BrandService getBrandServiceInstance() {
		
		if(brandServiceObj == null) {
			brandServiceObj = new BrandService();
		}
		
		return brandServiceObj;
	}
	
	private BrandManager getBrandManager() {
		return new BrandManager();
	}
	
	//services---------------------------	
	public boolean registerBrand(Brand brand) throws ClassNotFoundException, SQLException {
		return getBrandManager().addBrand(brand);
	}
	
	public Brand getSpecificBrand(int brandId) throws ClassNotFoundException, SQLException {
		return getBrandManager().getSpecificBrand(brandId);
	}
	
	public List<Brand> getAllBrands() throws ClassNotFoundException, SQLException {
		return getBrandManager().getAllBrands();
	}
	
	public boolean editTheBrand(Brand brand) throws ClassNotFoundException, SQLException {
		return getBrandManager().updateBrand(brand);
	}
	
	public boolean deleteTheBrand(int brandId) throws ClassNotFoundException, SQLException {
		return getBrandManager().deleteBrand(brandId);
	}

}
