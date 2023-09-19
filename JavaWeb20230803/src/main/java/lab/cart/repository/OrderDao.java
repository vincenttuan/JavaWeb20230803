package lab.cart.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import repository.MySQL;

public class OrderDao {
	
	// 該使用者的購物車中是否有此商品
	public boolean hasProductInCartByUserId(int userId, int productId) {
		String sql = "SELECT count(*) as count FROM orders where user_id = ? and product_id = ? and order_status = 0";
		try(PreparedStatement pstmt = MySQL.getInstance().getConnection().prepareStatement(sql);) {
			pstmt.setInt(1, userId);
			pstmt.setInt(2, productId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				return count >= 1;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
