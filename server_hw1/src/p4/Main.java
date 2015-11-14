package p4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MessageFactory.class);
		MessageBean message = context.getBean("messageBean", MessageBean.class);
		message.sayHello();
	}
}
