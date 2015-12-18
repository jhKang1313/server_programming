package aop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main(String args[]){
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans_aop.xml"));
		MessageBean message = (MessageBean)factory.getBean("proxy");

		message.sayHello();
	}
}
