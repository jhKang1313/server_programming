package Annotation;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao userDao = context.getBean("getUserDao", UserDao.class);
		
		System.out.println(userDao.getUserName("jssong"));
	}
}
