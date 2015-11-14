package p4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({OutputterFactory.class})
public class MessageFactory {
	@Autowired
	private FileOutputter fileOutputter;	//OutputterFactory�� fileOutputter()�� �����Ͽ� FileOutputter ��ü�� �����´�.

	@Bean
	public MessageBean messageBean(){
		MessageBeanImpl messageBean = new MessageBeanImpl("jhKang");	//MessageBeanImpl ��ü ����
		messageBean.setGreeting("�ȳ�");						//�λ縻 ����
		messageBean.setOutput(fileOutputter);				//output ����
		return messageBean;									//MessageBean ��ü ��ȯ
	}
}

