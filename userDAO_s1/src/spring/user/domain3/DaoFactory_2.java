package spring.user.domain3;


public class DaoFactory_2 {

	public UserDao_v4 userDao() {
		ConnectionMaker connMaker = connectionMaker();
		return new UserDao_v4(connMaker) ;
	}
//	public AccountDao accountDao() {
//		ConnectionMaker connMaker = connectionMaker();
//		return new AccountDao(connMaker) ;
//	}
//	public MessageDao messageDao() {
//		ConnectionMaker connMaker = connectionMaker();
//		return new MessageDao(connMaker) ;
//	}
	
	public ConnectionMaker connectionMaker() {
		return new NConnectionMaker() ;
	}
	
	
}
