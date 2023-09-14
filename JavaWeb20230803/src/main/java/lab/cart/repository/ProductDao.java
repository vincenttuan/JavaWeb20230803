package lab.cart.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lab.cart.repository.model.Product;
import repository.MySQL;

public class ProductDao {
	
	public List<Product> queryAll() {
		String sql = "select id, product_code, product_name, product_qty, product_price from products";
		List<Product> products = new ArrayList<>();
		try(Statement stat = MySQL.getInstance().getConnection().createStatement();
			ResultSet rs = stat.executeQuery(sql);) {
			
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setProductCode(rs.getString("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setProductQty(rs.getInt("product_qty"));
				product.setProductPrice(rs.getInt("product_price"));
				products.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
}
