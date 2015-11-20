package user2;

public class DaoFactory {
	public UserDao getuserDao() {
		ConnectionMaker connMaker = new DConnectionMaker() ;
		UserDao udao = new UserDao(connMaker) ;
		return udao;
	}
}
