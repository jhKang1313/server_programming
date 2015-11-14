package spring.user.domain;
import java.sql.*;

public abstract class UserDao_v2 {
	public abstract Connection getConnection() throws ClassNotFoundException, SQLException ;
//	{
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db4spring", "root", "12345");
//		return con ;
//	}
	
	public User getUser (String id) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
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
		Connection con = getConnection();
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
