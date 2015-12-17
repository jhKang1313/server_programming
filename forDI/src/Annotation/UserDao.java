package Annotation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	public UserDao(ConnectionMaker connectionMaker) throws ClassNotFoundException, SQLException{
		this.connection = connectionMaker.getConnection();
	}
	public void addUser(User user) throws ClassNotFoundException, SQLException{
		ps = connection.prepareStatement("insert into users(name, id, password) values (?,?,?) ");
		ps.setString(1, user.getName());
		ps.setString(2, user.getId());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
	}
	public String getUserName(String userID) throws ClassNotFoundException, SQLException{
		ps = connection.prepareStatement("select * from users where id=?");
		ps.setString(1, userID);
		String userName = "not Found";
		rs = ps.executeQuery();
		if(rs.next())
			userName = rs.getString("name");
		ps.close();
		rs.close();
		return userName;
	}
}
