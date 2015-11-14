package p2;
import java.sql.*;
public class AccessConnectionMaker implements ConnectionMaker{
	private String url;
	private String id;
	private String pw;
	public AccessConnectionMaker(String url, String id, String pw) {
		this.url = url;
		this.id = id;
		this.pw = pw;
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\users.mdb") ;
		return connection ;
	}
}
