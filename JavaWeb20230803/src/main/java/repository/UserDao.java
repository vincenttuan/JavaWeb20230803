package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import repository.model.User;

public class UserDao {
	
	private static Date getBirth(int yyyy, int mm, int dd) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, yyyy);
		calendar.set(Calendar.MONTH, mm-1); // 0~11
		calendar.set(Calendar.DAY_OF_MONTH, dd);
		return calendar.getTime();
	}
	
	// 查詢單筆
	public User getUserByName(String name) {
		return users.parallelStream()
					.filter(user -> user.getUsername().equals(name))
					.findAny()
					.orElse(null);
	}
	
	// 查詢多筆
	public List<User> queryAllUser() {
		List<User> users = new ArrayList();
		
		String sql = "select id, username, password, birth from users";
		try(Statement stmt = MySQL.getInstance().getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) { // 將資料列逐筆取出 
				// 將資料欄裡的資料依序取出
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Date birth = rs.getDate("birth");
				// 並注入到 user 物件
				User user = new User(id, username, password, birth);
				// 加入到 users 集合中
				users.add(user); 
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
}
