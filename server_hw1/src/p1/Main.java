package p1;

import java.sql.SQLException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		BeanFactory beanFactory= new XmlBeanFactory(new FileSystemResource("beans1.xml"));	//beans1.xml을 참조하여 Bean Factory 구성
		UserDao userDao = beanFactory.getBean("userDao", UserDao.class);		//XML 파일에서 bean의 id가 userDao인 bean 참조
		
		userDao.findUser("jssong").showData();						//탐색
		userDao.addUser(new User("강진혁", "jhKang1313", "1234"));	//삽입
		userDao.findUser("jhKang1313").showData();					//탐색
		
		userDao.close();	//DB 닫기
	}
}