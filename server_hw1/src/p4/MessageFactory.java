package p4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({OutputterFactory.class})
public class MessageFactory {
	@Autowired
	private FileOutputter fileOutputter;	//OutputterFactory의 fileOutputter()를 참조하여 FileOutputter 객체를 가져온다.

	@Bean
	public MessageBean messageBean(){
		MessageBeanImpl messageBean = new MessageBeanImpl("jhKang");	//MessageBeanImpl 객체 생성
		messageBean.setGreeting("안녕");						//인사말 설정
		messageBean.setOutput(fileOutputter);				//output 설정
		return messageBean;									//MessageBean 객체 반환
	}
}

