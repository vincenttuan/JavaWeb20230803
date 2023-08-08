package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//網址: .../servlet/lotto?count=5 表示要得到 5 個 (1~10) 不重複的幸運數字
//網址: .../servlet/lotto?count=2 表示要得到 2 個 (1~10) 不重複的幸運數字
//網址: .../servlet/lotto?count=0 表示要得到 1 個 (1~10) 的幸運數字
//網址: .../servlet/lotto?count=1 表示要得到 1 個 (1~10) 的幸運數字
//網址: .../servlet/lotto         表示要得到 1 個 (1~10) 的幸運數字

@WebServlet(urlPatterns = "/servlet/lotto")
public class LottoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 設定編碼
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8"); // 給瀏覽器看的
		
		PrintWriter out = resp.getWriter();
		
		// 2. 取得 count 字串參數
		String countStr = req.getParameter("count");
		int count = 1;
		if(countStr != null) {
			count = Integer.parseInt(countStr);
			if(count == 0) {
				count = 1;
			}
		}
		
		// 3. 取得 count 個(1~10)不重複的數字
		Random random = new Random();
		Set<Integer> nums = new LinkedHashSet<>();
		while (nums.size() < count) {
			nums.add(random.nextInt(10) + 1);
		}
		
		// 4. 回應
		out.print(String.format("%d 個幸運數字 %s", count, nums));
		
		
	}
	
}
