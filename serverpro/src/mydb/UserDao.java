package mydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private ConnectionMaker simpleMaker = new SimpleConnectionMaker();
	public User getUser (String id) throws ClassNotFoundException, SQLException {
		User user = new User(); 
		Connection con = simpleMaker.makeNewConnection();
		PreparedStatement ps = con.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if ( rs.next() ) {
			user.id = rs.getString("id");
			user.name = rs.getString("name");
			user.setPassword(rs.getString("password"));			
		}
		else {
			user.name="Error - Undefined ID!!";
			user.id=id;
		}
		rs.close();
		ps.close();
		con.close();
		
		return user;
	}
	public void addUser (User user) throws ClassNotFoundException, SQLException {
		Connection con = simpleMaker.makeNewConnection();
		PreparedStatement ps = con.prepareStatement("insert into users(id, name, password) values (?,?,?)");
		ps.setString(1, user.id);
		ps.setString(2, user.name);
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
		return ;
	}
	

}
