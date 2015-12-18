package server.spring.finalexam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SortingFactory {
	@Bean
	public String getSortingMethod(){
		return "up";
	}
}
