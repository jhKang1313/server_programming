package p1;
import java.sql.*;
public class AccessConnectionMaker implements ConnectionMaker{
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		//C 및에 존재하는 Access 파일
		Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\users.mdb") ;
		return connection ;
	}
}
