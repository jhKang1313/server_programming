package p1;
public class User {
	private String name;
	private String id;
	private String pw;
	public User(String name, String id, String pw){
		this.name = name;
		this.id = id;
		this.pw = pw;
	}
	public void showData(){
		System.out.println("Name : "+name);
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
	}
	public String getName(){
		return this.name;
	}
	public String getId(){
		return this.id;
	}
	public String getPw(){
		return this.pw;
	}
}
