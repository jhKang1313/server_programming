package p3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	
public class MessageFactory {
	@Bean
	public MessageBean messageBeanKr(){	
		return new MessageBeanKr();			//MessageBeanKr °´Ã¼¸¦ ¹ÝÈ¯
	}
	@Bean
	public MessageBean messageBeanEn(){
		return new MessageBeanEn();			//MessageBeanEn °´Ã¼¸¦ ¹ÝÈ¯
	}

}
