package p2;
import java.sql.*;
public class AccessConnectionMaker implements ConnectionMaker{
	private String url;
	public AccessConnectionMaker(String url) {
		this.url = url;
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection connection = DriverManager.getConnection(url) ;
		return connection ;
	}
}
