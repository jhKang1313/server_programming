package mydb;
import java.sql.*;

public class SimpleConnectionMaker implements ConnectionMaker{
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db4spring", "root", "12345");
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		  Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\users.mdb") ;
		return con ;
		
	}
		

}
