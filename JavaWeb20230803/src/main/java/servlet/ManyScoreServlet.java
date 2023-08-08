package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * .../servlet/many/score                     印出:請在網址列上輸入分數
 * .../servlet/many/score?score=100           印出:總分:100, 平均:100
 * .../servlet/many/score?score=100&score=80  印出:總分:180, 平均:90
 * */
@WebServlet(urlPatterns = "/servlet/many/score")
public class ManyScoreServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 設定編碼
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8"); // 給瀏覽器看的
		
		PrintWriter out = resp.getWriter();
		
		// 2. 取得 score 的參數, 因為 score 參數可能會有很多所以要用 getParameterValues()
		String[] scores = req.getParameterValues("score");
		if(scores == null) {
			out.print("請在網址列上輸入分數");
			return;
		}
		
		// 3. 計算總分
		IntSummaryStatistics stat = Arrays.stream(scores)
										  .mapToInt(Integer::parseInt)
										  .summaryStatistics();
		
		out.print(String.format("總分:%d, 平均:%.1f", stat.getSum(), stat.getAverage()));
		
	}
	
}
