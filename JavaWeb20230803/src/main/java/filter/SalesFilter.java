package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(value = {"/servlet/sales/*"})
public class SalesFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 判斷參數 pass=true 才要放行
		String pass = request.getParameter("pass");
		if(pass != null && pass.equals("true")) {
			chain.doFilter(request, response); // 放行
		} else {
			response.getWriter().print("Stop");
		}
		
	}
	
}
