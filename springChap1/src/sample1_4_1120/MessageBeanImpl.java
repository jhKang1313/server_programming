package sample1_4_1120;
public class MessageBeanImpl implements MessageBean {
	private String name ;
	public void setName(String name) {
		this.name = name;
	}
	public void sayHello() {
		try{
			Thread.sleep(5000);
		}catch(Exception e){e.printStackTrace();}
		System.out.println("Hello, " + name + "!!");
	}
	public void sayHi(){
		try{
			Thread.sleep(1000);
		}catch(Exception e){e.printStackTrace();}
		System.out.println("Hi, " + name + "!!");
	}
}
