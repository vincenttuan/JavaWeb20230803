package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * .../servlet/shoppingcar?name=coffee&coffee_price=100&coffee_price=80&name=cake&cake_price=50&cake_price=40&cake_price=30
 * 請印出總共買了那些商品, 每個商品各買了多少, 總金額為多少
 * 
 * 商品:coffee 數量:2 小計:180
 * 商品:cake 數量:3 小計:120
 * 總金額: 300
 * 
 * 注意: 有可能只買 coffee 沒有買 cake 或 coffee 與 cake 都沒買的狀況
 * */

@WebServlet("/servlet/shoppingcar")
public class ShoppingCarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
