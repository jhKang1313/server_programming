package user2;

import java.sql.SQLException;

public class UserDaoTest {
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		UserDao udao = new DaoFactory().getuserDao();
		User t1 = new User() ; 
		t1 = udao.getUser("jssong") ;
		System.out.println(t1.name) ;
		System.out.println(t1.getPassword()) ;
		
	}

}
