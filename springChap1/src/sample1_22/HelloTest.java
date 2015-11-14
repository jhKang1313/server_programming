package sample1_22;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloTest {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(
				new FileSystemResource("beans22.xml")) ;
		MessageBean bean = factory.getBean(
				"messageBean", MessageBean.class) ;
				;
		bean.sayHello();
		
//		MessageBeanImpl m1 = new MessageBeanImpl() ;
//		m1.setGreeting("�ȳ��ϼ��� ");
//		m1.setName("Spring");
//		m1.sayHello();
	}
}
