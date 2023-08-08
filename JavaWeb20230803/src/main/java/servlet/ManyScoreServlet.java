package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * .../servlet/many/score                     印出:請輸入分數
 * .../servlet/many/score?score=100           印出:總分:100, 平均:100
 * .../servlet/many/score?score=100&score=80  印出:總分:180, 平均:90
 * */
@WebServlet(urlPatterns = "/servlet/many/score")
public class ManyScoreServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
