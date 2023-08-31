package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import repository.model.Sales;

public class SalesDao {
	private Connection conn;
	
	public SalesDao() {
		MySQL mySQL = MySQL.getInstance();
		conn = mySQL.getConnection();
	}
	
	// 查詢所有 product
	public List<String> queryAllProduct() {
		List<String> products = new ArrayList<>();
		String sql = "select distinct product from sales_data";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			while (rs.next()) {
				products.add(rs.getString("product"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	// 查詢所有資料
	public List<Sales> queryAll() {
		// 收集所有 sales_data 資料的容器
		List<Sales> salesList = new ArrayList<>();
		
		String sql = "select id, date, product, price, qty, city, branch from sales_data";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			// 將資料逐筆抓出並加入到 salesList 中
			while (rs.next()) {
				Sales sales = new Sales();
				sales.setId(rs.getInt("id"));
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
	
	// 新增
	public int create(Sales sales) {
		String sql = "insert into sales_data(date, product, price, qty, city, branch) values(?, ?, ?, ?, ?, ?)";
		int rowcount = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, sales.getDate());
			pstmt.setString(2, sales.getProduct());
			pstmt.setInt(3, sales.getPrice());
			pstmt.setInt(4, sales.getQty());
			pstmt.setString(5, sales.getCity());
			pstmt.setString(6, sales.getBranch());
			rowcount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowcount;
	}
}

