package sample2;

public class HelloTest {

	public static void main(String[] args) {
		MessageBean m1 = new MessageBeanKr() ;
		MessageBean m2 = new MessageBeanEn() ;
		m1.sayHello("Spring");
		m2.sayHello("Spring");
	}
}
