package spring.user.domain;
import java.sql.*;

public class UserDao {
	public User getUser (String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/server_prog", "root", "wlsgur1313");
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
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		UserDao udao = new UserDao();
		User user = udao.getUser("jssong");
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getId() + "조회 성공");
		
		user = udao.getUser("nobody");
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getId() + "없는 이름 확인");
	}

}
