package repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import repository.model.User;

public class UserDao {
	
	// In-memory Database
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1, "john", "1234", getBirth(1954, 12, 8)));
		users.add(new User(2, "mary", "5678", getBirth(1973, 12, 18)));
		users.add(new User(3, "jack", "1111", getBirth(1982, 10, 10)));
		users.add(new User(4, "rose", "2222", getBirth(1990, 8, 8)));
		users.add(new User(5, "anna", "3333", getBirth(2002, 5, 3)));
	}
	
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
		return users;
	}
	
}
