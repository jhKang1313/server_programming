package mydb;

public class User {
	public String id;
	public String name;
	private String password;

	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password) 
	{
		this.password = password; 
	}

}
