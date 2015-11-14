package p3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	
public class MessageFactory {
	@Bean
	public MessageBean messageBeanKr(){	
		return new MessageBeanKr();			//MessageBeanKr ��ü�� ��ȯ
	}
	@Bean
	public MessageBean messageBeanEn(){
		return new MessageBeanEn();			//MessageBeanEn ��ü�� ��ȯ
	}

}
