package test;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		BeanFactory beanFactory= new XmlBeanFactory(new FileSystemResource("beans1.xml"));	//beans1.xml을 참조하여 Bean Factory 구성
		ConnectionMaker connection = beanFactory.getBean("connection", ConnectionMaker.class);		//XML 파일에서 bean의 id가 userDao인 bean 참조
		UserDao userDao = new UserDao(connection);
		System.out.println(userDao.getUserName("sung"));
		
	}

}
