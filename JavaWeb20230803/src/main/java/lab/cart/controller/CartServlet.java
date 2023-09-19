package lab.cart.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lab.cart.service.OrderService;

@WebServlet(value = "/lab/cart")
public class CartServlet extends HttpServlet {
	
	private OrderService orderService = new OrderService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得登入者的 id
		HttpSession session = req.getSession(false);
 		int userId = Integer.parseInt(session.getAttribute("userid")+"");
 		
 		// 取得 action
 		String action = req.getParameter("action");
 		switch (action) {
 			case "view":
 				// 檢視購物車資料
 				
				break;
 			default:
 				// 新增商品
 				addProduct(req, resp, userId);
 				break;
		}
 		
 		
	}
	
	// 新增商品
	private void addProduct(HttpServletRequest req, HttpServletResponse resp, int userId) throws ServletException, IOException {
		// 取得商品 id
 		int productId = Integer.parseInt(req.getParameter("product_id"));
 		
 		// 該使用者的購物車中是否有此商品 
 		boolean hasProduct = orderService.hasProductInCartByUserId(userId, productId);
 		int qty = 1;
 		if(hasProduct) {
 			orderService.modifyProductQtyInCartByProductId(userId, productId, qty);
 		} else {
 			orderService.addProductInCart(userId, productId, qty);
 		}
		
 		//resp.getWriter().print("CartServlet OK, Please check database first~");
 		resp.sendRedirect(getServletContext().getContextPath() + "/lab/product");
	} 
	
}
