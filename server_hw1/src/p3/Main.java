package p3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
	public static void main(String args[]){
		ApplicationContext context = new AnnotationConfigApplicationContext(MessageFactory.class);	
		MessageBean message = context.getBean("messageBeanEn", MessageBean.class);	//@Bean이 붙은 messageBeanEn 함수로 MessageBeanEn 객체를 가져온다.
		message.sayHello("진혁");
	}

}
