package p2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnectionMaker implements ConnectionMaker{
	private String url;
	private String id;
	private String pw;
	public MySQLConnectionMaker(String url, String id, String pw) {
		this.url = url;
		this.id = id;
		this.pw = pw;
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url,id, pw); //localhost�� �����ϴ� �����ͺ��̽� 
		return connection;
	}
}
