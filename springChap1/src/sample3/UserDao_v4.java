package sample3;
import java.sql.*;

public class UserDao_v4 {
	private ConnectionMaker connMaker ;
	UserDao_v4(ConnectionMaker connMaker) {
		this.connMaker = connMaker ;
	}
	
	public User getUser (String id) throws ClassNotFoundException, SQLException {
		Connection con = connMaker.makeNewConnection();
		PreparedStatement ps = con.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		User user = new User();
		if ( rs.next() ) {
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));			
		}
		else {
			user.setName("Error - Undefined ID!!");
			user.setId(id);
		}
		rs.close();
		ps.close();
		con.close();
		
		return user ;
		
	}
	public void addUser (User user) throws ClassNotFoundException, SQLException {
		Connection con = connMaker.makeNewConnection();
		PreparedStatement ps = con.prepareStatement("insert into users(id, name, password) values (?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
		return ;
	}

}
