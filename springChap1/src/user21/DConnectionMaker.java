package user21;


import java.sql.*;

public class DConnectionMaker implements ConnectionMaker {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\users.mdb") ;
		return con ;
		
	}

}