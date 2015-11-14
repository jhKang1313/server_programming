package sample1_2;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {

	private String name ;
	private String greeting ;
	private FileOutputter output;
	MessageBeanImpl (String name) {
		this.name = name ;
	}
	public void setOutput(FileOutputter output){
		this.output = output;
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

	public void sayHello(){
		String message = greeting + name + "!!";
		System.out.println(message);
		try{
		output.output(message);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
