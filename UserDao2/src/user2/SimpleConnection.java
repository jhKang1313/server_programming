package user2;

import java.sql.*;

public class SimpleConnection {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db4spring", "root", "12345");
		
		return con ;
	}
	

}
