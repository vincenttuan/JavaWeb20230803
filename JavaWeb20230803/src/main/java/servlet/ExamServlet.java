package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/exam")
public class ExamServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8"); // 給瀏覽器看的
		
		// 設定回應物件
		PrintWriter out = resp.getWriter();
		out.println("請按下此 <a href='/JavaWeb20230803/html/examform.html'>連結</a> 進入到考試註冊頁面");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 設定編碼
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8"); // 給瀏覽器看的
		
		// 設定回應物件
		PrintWriter out = resp.getWriter();
		
		// 2. 取得參數
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String examNo = req.getParameter("examNo");
		String examFee = req.getParameter("examFee");
		String paid = req.getParameter("paid");
		String examDate = req.getParameter("examDate");
		String[] examPeriods = req.getParameterValues("examPeriod");
		String memo = req.getParameter("memo");
		
		// 3. 回應內容
		out.print(String.format("姓名: %s <p>", name));
		out.print(String.format("密碼: %s <p>", password));
		out.print(String.format("代號: %s <p>", examNo));
		out.print(String.format("費用: %s <p>", examFee));
		out.print(String.format("繳費: %s <p>", paid));
		out.print(String.format("日期: %s <p>", examDate));
		out.print(String.format("時段: %s <p>", Arrays.toString(examPeriods)));
		out.print(String.format("備註: %s <p>", memo));
		
		out.print("<button type='button' onclick='history.back()' >回上一頁</button>");
	}
	
	
	
}
