package sample1_22;

public class MessageBeanImpl implements MessageBean {

	private String name ;
	private String greeting ;
	
	MessageBeanImpl (String name) {
		this.name = name ;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void sayHello() {
		String message = greeting + name + "!!" ;
		System.out.println(message);
		
	//	private FileOutputter output ;
	//	output.output(message) ;
	}
}











