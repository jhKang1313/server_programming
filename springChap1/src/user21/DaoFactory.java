package user21;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDaoN() {
		return new UserDao(new NConnectionMaker()) ;
	}
	@Bean
	public UserDao userDaoD() {
		return new UserDao(new DConnectionMaker()) ;
	}
	
}
