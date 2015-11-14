package user21;

import java.sql.*;

public class UserDao {
	ConnectionMaker connMaker ;
	UserDao (ConnectionMaker connMaker) {
		this.connMaker = connMaker ;
	}
	
	public void addUser (User user) throws ClassNotFoundException, SQLException {
		Connection con = connMaker.getConnection() ;
		PreparedStatement ps = con.prepareStatement("insert into users(id, name, password) values (?,?,?)");
		ps.setString(1, user.id);
		ps.setString(2, user.name);
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	
	public User getUser (String id) throws ClassNotFoundException, SQLException {
		User user = new User() ;
		Connection con = connMaker.getConnection() ;
		
		PreparedStatement ps = con.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		if ( rs.next() ) {
			user.id = rs.getString("id");
			user.name = rs.getString("name");
			user.setPassword(rs.getString("password"));			
		}
		else {
			user.name = "Error - Undefined ID!!";
			user.id = id;
		}
		rs.close();
		ps.close();
		con.close();
		
		return user ;
	}
		
 	
}
