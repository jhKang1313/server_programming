package p1;

import java.sql.*;
public interface ConnectionMaker {
	public Connection getConnection() throws ClassNotFoundException, SQLException;
}
