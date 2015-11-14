package spring.user.domain;
import java.sql.*;

public class SimpleConnectionMaker {
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db4spring", "root", "12345");
		return con ;
		
	}
		

}
