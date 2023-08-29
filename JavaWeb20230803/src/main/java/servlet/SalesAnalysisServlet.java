package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.model.Sales;
import service.SalesService;

@WebServlet(urlPatterns = "/servlet/sales/analysis")
public class SalesAnalysisServlet extends HttpServlet {
	private SalesService salesService = new SalesService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Map<String, Integer> salesMap = salesService.getBranchSales();
		//Map<String, Integer> salesMap = salesService.getCitySales();
		Map<String, Integer> salesMap = salesService.getProductSales();
		
		// 重導到 sales.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/salesanalysis.jsp");
		// 傳遞參數
		req.setAttribute("salesMap", salesMap);
		rd.forward(req, resp);
		
	}
	
}
