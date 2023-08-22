package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

@WebServlet(urlPatterns = "/servlet/user/add")
public class UserAddServlet extends HttpServlet {
	private UserService userService = new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String birthStr = req.getParameter("birth");
		
		// 檢查 username, password, birthStr 是否合法
		// 暫不處理 ...
		
		// 進入到新增服務程序
		int rowcount = userService.add(username, password, birthStr);
		
		resp.getWriter().print(rowcount);
		
	}
	
}
