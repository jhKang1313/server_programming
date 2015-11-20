package user21;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
//		DaoFactory factory = new DaoFactory() ;
//		UserDao udao = factory.getUserDao() ;
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class) ;
		UserDao udo = context.getBean("userDaoN", UserDao.class);
		
		
		User t1 = new User() ; 
		t1 = udo.getUser("jssong") ;
		System.out.println(t1.name) ;
		System.out.println(t1.getPassword()) ;
		
		
	}

}
