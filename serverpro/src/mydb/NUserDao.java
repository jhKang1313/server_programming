package mydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao{
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		  Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\users.mdb") ;
		return con;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		UserDao udao = new NUserDao();
		User t1 = new User();
		t1 = udao.getUser("jssong");
		System.out.println(t1.name);
		System.out.println(t1.getPassword());
		
		
		
	}

}
