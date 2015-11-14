package sample31;

import java.sql.*;

public interface ConnectionMaker {
	public Connection getConnection() throws ClassNotFoundException, SQLException ;
	

}
