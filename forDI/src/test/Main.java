package test;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		BeanFactory beanFactory= new XmlBeanFactory(new FileSystemResource("beans1.xml"));	//beans1.xml�� �����Ͽ� Bean Factory ����
		ConnectionMaker connection = beanFactory.getBean("connection", ConnectionMaker.class);		//XML ���Ͽ��� bean�� id�� userDao�� bean ����
		UserDao userDao = new UserDao(connection);
		System.out.println(userDao.getUserName("sung"));
		
	}

}
