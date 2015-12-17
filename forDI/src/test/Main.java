package test;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		BeanFactory beanFactory= new XmlBeanFactory(new FileSystemResource("beans1.xml"));	//beans1.xml�� �����Ͽ� Bean Factory ����
		UserDao userDao = beanFactory.getBean("userDao", UserDao.class);		//XML ���Ͽ��� bean�� id�� userDao�� bean ����
		
		System.out.println(userDao.getUserName("������"));
		
	}

}
