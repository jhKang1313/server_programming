package spring.user.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DUserDao extends UserDao_v2 {
	public Connection getConnection () throws ClassNotFoundException, SQLException {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
		String url = "jdbc:ucanaccess://C:/CS-Board2003.mdb";
		Connection conn = DriverManager.getConnection(url); 
		return conn ;
	}

	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		UserDao_v2 udao = new DUserDao();
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
