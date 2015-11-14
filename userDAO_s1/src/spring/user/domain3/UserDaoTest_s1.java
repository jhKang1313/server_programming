package spring.user.domain3;

import java.sql.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

public class UserDaoTest_s1 {
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory_s1.class) ;
		UserDao_v4 udao = context.getBean("userDao", UserDao_v4.class);
		
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
