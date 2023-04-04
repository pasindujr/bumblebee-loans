package com.pasindujr.bumblebeeloans.service;

import com.pasindujr.bumblebeeloans.dao.StockManager;
import com.pasindujr.bumblebeeloans.model.Stock;

import java.sql.SQLException;
import java.util.List;

public class StockService {

	private static StockService stockServiceObj;

	private StockService() {

	}

	public static synchronized StockService getStockServiceInstance() {

		if(stockServiceObj == null) {
			stockServiceObj = new StockService();
		}

		return stockServiceObj;
	}

	private StockManager getStockManager() {
		return new StockManager();
	}

	//services---------------------------
	public boolean registerStock(Stock stock) throws ClassNotFoundException, SQLException {
		return getStockManager().addStock(stock);
	}

	public Stock getSpecificStock(int stockId) throws ClassNotFoundException, SQLException {
		return getStockManager().getSpecificStock(stockId);
	}

	public List<Stock> getAllStocks() throws ClassNotFoundException, SQLException {
		return getStockManager().getAllStocks();
	}

	public boolean editTheStock(Stock stock) throws ClassNotFoundException, SQLException {
		return getStockManager().updateStock(stock);
	}

	public boolean deleteTheStock(int stockId) throws ClassNotFoundException, SQLException {
		return getStockManager().deleteStock(stockId);
	}

}
