package p2;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		BeanFactory beanFactory= new XmlBeanFactory(new FileSystemResource("bean2.xml"));
		UserDao userDao = beanFactory.getBean("userDao", UserDao.class);
		
		userDao.findUser("jssong").showData();		//Ž��
		//userDao.addUser(new User("������", "jhKang1313", "1234"));	//����
		userDao.findUser("jhKang1313").showData();	//Ž��
	}
}
