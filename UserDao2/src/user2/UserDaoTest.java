package user2;

import java.sql.SQLException;

public class UserDaoTest {
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		ConnectionMaker connMaker = new NConnectionMaker() ;
		
		UserDao2 udao = new UserDao2(connMaker) ;
		User t1 = new User() ; 
		t1 = udao.getUser("jssong") ;
		System.out.println(t1.name) ;
		System.out.println(t1.getPassword()) ;
		
	}

}
