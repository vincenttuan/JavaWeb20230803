package repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import repository.model.User;

public class UserDao {
	
	// In-memory Database
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1, "john", "1234", new Date()));
		users.add(new User(2, "mary", "5678", new Date()));
		users.add(new User(3, "jack", "1111", new Date()));
		users.add(new User(4, "rose", "2222", new Date()));
		users.add(new User(5, "anna", "3333", new Date()));
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
