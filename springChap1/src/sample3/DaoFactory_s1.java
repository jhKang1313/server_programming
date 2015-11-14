package sample3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory_s1 {

	@Bean
	public UserDao_v4 userDao() {
		ConnectionMaker connMaker = connectionMaker();
		return new UserDao_v4(connMaker) ;
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new NConnectionMaker() ;
	}
	
	
}
