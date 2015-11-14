package p1;
import java.sql.*;
public class AccessConnectionMaker implements ConnectionMaker{
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\users.mdb") ;
		return connection ;
	}
}
