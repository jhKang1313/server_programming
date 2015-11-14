package spring.user.domain;
import java.sql.*;

public class NUserDao extends UserDao_v2 {
	public Connection getConnection () throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/server_prog", "jhKang1313", "1234");
		return con ;
	}

	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		UserDao_v2 udao = new NUserDao();
		User user2 = udao.getUser("jssong");
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " 조회 성공");
		user2 = udao.getUser("whiteShip");
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " 조회 성공");
	}
	
}
