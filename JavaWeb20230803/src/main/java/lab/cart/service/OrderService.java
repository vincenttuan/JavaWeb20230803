package lab.cart.service;

import lab.cart.repository.OrderDao;

public class OrderService {
	private OrderDao orderDao = new OrderDao();
	
	// 該使用者的購物車中是否有此商品
	public boolean hasProductInCartByUserId(int userId, int productId) {
		return orderDao.hasProductInCartByUserId(userId, productId);
	}
	
	// 新增商品到購物車中
	public boolean addProductInCart(int userId, int productId, int qty) {
		return orderDao.addProductInCart(userId, productId, 1);
	}
	
	// 修改購物車中該商品的數量
	// 根據 qty 的正負值來修正數量
	public boolean modifyProductQtyInCartByProductId(int userId, int productId, int qty) {
		return orderDao.modifyProductQtyInCartByProductId(userId, productId, qty);
	}
	
}
