package p3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageFactory {
	@Bean
	public MessageBean messageBeanKr(){
		return new MessageBeanKr();
	}
	@Bean
	public MessageBean messageBeanEn(){
		return new MessageBeanEn();
	}

}
