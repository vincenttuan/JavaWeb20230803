package service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import repository.SalesDao;
import repository.model.Sales;


public class SalesService {
	private SalesDao salesDao = new SalesDao();
	
	// 查詢全部資料
	public List<Sales> findAll() {
		return salesDao.queryAll();
	}
	
	// 根據分店印出每一家的銷售金額
	public Map<String, Integer> getBranchSales() {
		return salesDao.queryAll().stream()
				.collect(groupingBy(Sales::getBranch, 
									summingInt(sales -> sales.getPrice() * sales.getQty())));
	}
	
	// 根據地區(city)印出每區的銷售金額
	public Map<String, Integer> getCitySales() {
		return salesDao.queryAll().stream()
				.collect(groupingBy(Sales::getCity, 
									summingInt(sales -> sales.getPrice() * sales.getQty())));
	}
	
	// 根據產品(product)印出每一種產品的銷售金額
	public Map<String, Integer> getProductSales() {
		return salesDao.queryAll().stream()
				.collect(groupingBy(Sales::getProduct, 
									summingInt(sales -> sales.getPrice() * sales.getQty())));
	}
	
}
