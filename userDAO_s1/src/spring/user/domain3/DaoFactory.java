package spring.user.domain3;


public class DaoFactory {

	public UserDao_v4 userDao() {
		ConnectionMaker connMaker = new NConnectionMaker();
		UserDao_v4  userDao = new UserDao_v4(connMaker) ;
		return userDao ;
	}
	
	
}
