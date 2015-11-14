package sample1_2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloTest {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(
				new FileSystemResource("beans2.xml")) ;
		MessageBean bean = factory.getBean(
				"messageBean", MessageBean.class) ;
				;
		bean.sayHello();
		
//		MessageBeanImpl m1 = new MessageBeanImpl() ;
//		m1.setGreeting("æ»≥Á«œººø‰ ");
//		m1.setName("Spring");
//		m1.sayHello();
	}
}
