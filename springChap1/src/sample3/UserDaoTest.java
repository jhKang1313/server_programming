package sample3;

import java.sql.*;

public class UserDaoTest {
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
//		UserDao_v4 udao = new DaoFactory().userDao();
		UserDao_v4 udao = new DaoFactory_2().userDao();
		
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
