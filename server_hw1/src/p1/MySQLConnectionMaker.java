package p1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnectionMaker implements ConnectionMaker{
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		//localhost에 존재하는 스키마 및 Connection 계정
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/server_prog","jhKang1313", "1234");  
		return connection;
	}
}
