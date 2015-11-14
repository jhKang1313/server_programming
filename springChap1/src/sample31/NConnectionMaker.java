package sample31;

import java.sql.*;

public class NConnectionMaker implements ConnectionMaker {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://113.198.82.111/db4spring", "root", "12345");
		
		return con ;
		
	}

}
