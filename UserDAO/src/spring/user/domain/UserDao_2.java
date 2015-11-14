package spring.user.domain;
import java.sql.*;

public class UserDao_2 {
	public User getUser (String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db4spring", "root", "12345");
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
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db4spring", "root", "12345");
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
		UserDao_2 udao = new UserDao_2();
		User user = new User() ;
		user.setId("whiteShip");
		user.setName("마봉춘");
		user.setPassword("married");
		
		udao.addUser(user) ;
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = udao.getUser(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + " 조회 성공");
	}

}
