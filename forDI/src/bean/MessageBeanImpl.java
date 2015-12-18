package bean;

public class MessageBeanImpl implements MessageBean{
	private String greeting;
	private String name;
	
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MessageBeanImpl(String name){
		this.name = name;
	}
	public void sayHello(){
		System.out.println(greeting + " " + name);
	}
}
