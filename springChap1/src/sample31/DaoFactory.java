package sample31;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

	@Bean
	public UserDao userDao() {
		ConnectionMaker connMaker = new NConnectionMaker() ;		
		UserDao udao = new UserDao(connMaker) ;
		return udao ;
	}

}
