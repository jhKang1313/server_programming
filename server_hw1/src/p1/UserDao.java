package p1;
import java.sql.*;
public class UserDao{
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	public UserDao(ConnectionMaker connection) throws ClassNotFoundException, SQLException{
		this.connection = connection.getConnection();
	}
	public void addUser(User user) throws ClassNotFoundException, SQLException{
		preparedStatement = connection.prepareStatement("insert into users(name, id, password) values (?,?,?)");
		preparedStatement.setString(1,  user.getName());
		preparedStatement.setString(2,  user.getId());
		preparedStatement.setString(3,  user.getPw());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	public User findUser(String userID) throws ClassNotFoundException, SQLException{
		preparedStatement = connection.prepareStatement("select * from users where id = ?");
		preparedStatement.setString(1, userID);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			User user =  new User(resultSet.getString("name"), resultSet.getString("id"), resultSet.getString("password"));
			preparedStatement.close();
			resultSet.close();
			return user;
		}
		else{
			preparedStatement.close();
			resultSet.close();
			return null;
		}
	}
	public void close() throws ClassNotFoundException, SQLException{
		connection.close();
	}
}
