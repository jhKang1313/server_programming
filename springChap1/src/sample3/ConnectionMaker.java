package sample3;
import java.sql.*;

public interface ConnectionMaker {
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException ;
		

}
