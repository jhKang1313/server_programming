package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Annotation.ConnectionMaker;

public class UserDao {
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	public UserDao(test.ConnectionMaker connection2) throws ClassNotFoundException, SQLException{
		this.connection = connection2.getConnection();
	}
	public void addUser(User user) throws ClassNotFoundException, SQLException{
		ps = connection.prepareStatement("insert into users(id, name, password) values (?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		ps.close();
	}
	public String getUserName(String userID) throws ClassNotFoundException, SQLException{
		String name = "";
		ps = connection.prepareStatement("select * from users where id=?");
		ps.setString(1, userID);
		
		rs = ps.executeQuery();
		if(rs.next())
			name = rs.getString("name");		
		
		rs.close();
		ps.close();
		return name;
	}
}
