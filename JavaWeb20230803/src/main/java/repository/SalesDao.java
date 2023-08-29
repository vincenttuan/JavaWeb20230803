package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import repository.model.Sales;

public class SalesDao {
	
	// 查詢所有資料
	public List<Sales> queryAll() {
		// 收集所有 sales_data 資料的容器
		List<Sales> salesList = new ArrayList<>();
		MySQL mySQL = MySQL.getInstance();
		String sql = "select date, product, price, qty, city, branch from sales_data";
		try(Connection conn = mySQL.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			// 將資料逐筆抓出並加入到 salesList 中
			while (rs.next()) {
				Sales sales = new Sales();
				sales.setDate(rs.getString("date"));
				sales.setProduct(rs.getString("product"));
				sales.setPrice(rs.getInt("price"));
				sales.setQty(rs.getInt("qty"));
				sales.setCity(rs.getString("city"));
				sales.setBranch(rs.getString("branch"));
				// 加入到集合
				salesList.add(sales);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return salesList;
	}
	
}
