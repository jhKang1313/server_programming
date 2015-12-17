package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessConnectionMaker implements ConnectionMaker{
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\users.mdb");
		return con;
	}
}
