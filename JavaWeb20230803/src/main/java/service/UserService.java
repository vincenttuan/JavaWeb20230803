package service;

import java.util.List;

import repository.UserDao;
import repository.model.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	// 登入確認
	public boolean loginCheck(String username, String password) {
		User user = userDao.getUserByName(username); // 透過 username 找到是否有此人
		if(user == null) { // 無此人
			return false;
		} if(user.getPassword().equals(password)) { // 比對 password 是否相等 
			return true; 
		} else { // password 不相等
			return false;
		}
	}
	
	// 取得所有 user
	public List<User> findAllUser() {
		return userDao.queryAllUser();
	}
	
}
