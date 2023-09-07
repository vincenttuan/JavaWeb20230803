package servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/servlet/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String product = req.getParameter("product");
		
		switch (action) {
			case "add": // 新增一筆
				addToCart(req, product);
				resp.sendRedirect("./product");
				break;
			case "submit": // 清除購物車資料
				submitToCart(req, resp);
				break;
			case "view": // 查看購物車
				viewCart(req, resp);
				break;
		}
		
	}
	
	private void submitToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// 將 session 全部清除
		session.invalidate();
		
		req.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req, resp);
	}
	
	private void viewCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 建立 Session 若 session 已經存在則會繼續使用而不會重新創建
		HttpSession session = req.getSession();
		// 取得購物車的 session 紀錄
		Map<String, Integer> cart = (Map<String, Integer>)session.getAttribute("cart");
		
		req.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req, resp);
	}
	
	private void addToCart(HttpServletRequest req, String product) {
		// 建立 Session 若 session 已經存在則會繼續使用而不會重新創建
		HttpSession session = req.getSession();
		// 取得購物車的 session 紀錄
		// Map<String, Integer> <商品代號, 購買數量>
		Map<String, Integer> cart = (Map<String, Integer>)session.getAttribute("cart");
		// 判斷是否有 cart
		if(cart == null) {
			cart = new LinkedHashMap<>();
		}
		// 將商品放入到購物車中
		int qty = cart.getOrDefault(product, 0); // 取得該商品之前是否已有購買的數量,若無則得到0
		qty = qty + 1; // 累加購買一筆
		// 將最數量回寫到 cart 中
		cart.put(product, qty);
		// 將 cart 寫入到 session 變數中
		session.setAttribute("cart", cart);
	}
	
	
	
}
