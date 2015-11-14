package sample4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {
    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans4.xml"));
        MessageBean bean = (MessageBean)factory.getBean("proxy");

        bean.sayHello();
        bean.sayHi();
    }

}
