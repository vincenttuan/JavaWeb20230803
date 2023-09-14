package lab.cart.service;

import java.util.List;

import lab.cart.repository.ProductDao;
import lab.cart.repository.model.Product;

public class ProductService {
	
	private ProductDao productDao = new ProductDao();
	
	public List<Product> findAll() {
		return productDao.queryAll();
	}
	
}
