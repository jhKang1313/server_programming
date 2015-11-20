package sample1_4_1120;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {
	public static void main(String[] rags){
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans4_1120.xml"));
		MessageBean bean = factory.getBean("proxy", MessageBean.class);
		
		bean.sayHello();
		bean.sayHi();
	}
}
