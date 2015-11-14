package p4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({OutputterFactory.class})
public class MessageFactory {
	@Autowired
	private FileOutputter fileOutputter;

	@Bean
	public MessageBean messageBean(){
		MessageBeanImpl messageBean = new MessageBeanImpl("jhKang");
		messageBean.setGreeting("¾È³ç");
		messageBean.setOutput(fileOutputter);
		return messageBean;
	}
}

