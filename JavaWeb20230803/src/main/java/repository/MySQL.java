package repository;

import java.sql.Connection;
import java.sql.DriverManager;

// 利用 SingleTon 模式
public class MySQL {
	
	private static MySQL _instance = new MySQL();
	
	private Connection conn;
	
	private MySQL() {
		try {
			// 1.mysql driver 註冊
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.建立 mysql 連線
			String dbUrl = "jdbc:mysql://localhost:3306/web?zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
			String username = "root";
			String password = "12345678";
			conn = DriverManager.getConnection(dbUrl, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MySQL getInstance() {
		return _instance;
	}
	
	// 取得資料庫連線
	public Connection getConnection() {
		return conn;
	}
	
	// 關閉資料庫連線
	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
