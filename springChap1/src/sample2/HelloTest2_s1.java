package sample2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloTest2_s1 {
	public static void main(String[] args){
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("bean0.xml"));
		
		MessageBean bean = factory.getBean("messageBean", MessageBean.class);
		bean.sayHello("Spring");
		
	}
}
