package spring.user.domain;
import java.sql.*;

public class UserDao_3 {
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db4spring", "root", "12345");
		return con ;
	}
	
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
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		UserDao_3 udao = new UserDao_3();
		User user2 = udao.getUser("jssong");
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " ��ȸ ����");
		user2 = udao.getUser("whiteShip");
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " ��ȸ ����");
	}

}