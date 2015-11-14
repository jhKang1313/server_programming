package sample5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
		ApplicationContext factory = new FileSystemXmlApplicationContext("beans5.xml");
        MessageBean bean = (MessageBean)factory.getBean("targetBean");

        bean.sayHello();
        bean.sayHi();
    }

}
