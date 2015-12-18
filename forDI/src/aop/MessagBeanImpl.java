package aop;

public class MessagBeanImpl implements MessageBean{
	@Override
	public void sayHello() {
		System.out.println("Hello World");
	}
}
