package Annotation;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao getUserDao() throws ClassNotFoundException, SQLException{
		return new UserDao(new AccessConnectionMaker());
	}
}
