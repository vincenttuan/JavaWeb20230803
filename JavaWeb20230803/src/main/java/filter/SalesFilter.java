package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(value = {"/servlet/sales/*"})
public class SalesFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username != null && password != null) {
			// 有帶 username 與 password 的參數
			case2(request, response, chain, username, password);
		} else {
			// 沒有帶 username 與 password 的參數
			case1(request, response, chain);
		}
		
	}
	
	// 沒有帶 username 與 password 的參數
	private void case2(HttpServletRequest request, HttpServletResponse response, FilterChain chain, 
						String username, String password) throws IOException, ServletException {
		
	}
	
	// 沒有帶 username 與 password 的參數
	private void case1(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		// 判斷是否有登入的 session 屬性資料
		HttpSession session = request.getSession(false);
		// 取得 session 的登入狀態紀錄 login_status
		if(session != null) { 
			String login_status = session.getAttribute("login_status") + "";
			if(login_status.equals("true")) {
				chain.doFilter(request, response); // 放行
			} else {
				// 導向登入頁面給前端
				request.getRequestDispatcher("/WEB-INF/jsp/salesloginform.jsp").forward(request, response);
			}
		} else {
			// 導向登入頁面給前端
			request.getRequestDispatcher("/WEB-INF/jsp/salesloginform.jsp").forward(request, response);
		}
	}
	
}
