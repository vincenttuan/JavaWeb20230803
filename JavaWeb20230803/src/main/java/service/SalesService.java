package service;

import java.util.List;

import repository.SalesDao;
import repository.model.Sales;

public class SalesService {
	private SalesDao salesDao = new SalesDao();
	
	// 查詢全部資料
	public List<Sales> findAll() {
		return salesDao.queryAll();
	}
	
	
}
