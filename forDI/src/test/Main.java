package test;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		BeanFactory beanFactory= new XmlBeanFactory(new FileSystemResource("beans1.xml"));	//beans1.xml을 참조하여 Bean Factory 구성
		UserDao userDao = beanFactory.getBean("userDao", UserDao.class);		//XML 파일에서 bean의 id가 userDao인 bean 참조
		
		System.out.println(userDao.getUserName("윤성민"));
		
	}

}
