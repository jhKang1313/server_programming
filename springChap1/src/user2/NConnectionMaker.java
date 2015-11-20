package user2;

import java.sql.*;

public class NConnectionMaker implements ConnectionMaker {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/server_prog",
				                                 "root", "wlsgur1313");
		return con;
		
	}

}
