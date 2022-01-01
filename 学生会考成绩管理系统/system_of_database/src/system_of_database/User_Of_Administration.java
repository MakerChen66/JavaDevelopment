package system_of_database;

public class User_Of_Administration {
	
	private String id;
	private String username;
	private String password;
	
	public User_Of_Administration() {
	}
	
	public User_Of_Administration(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	public User_Of_Administration(String id,String username,String password) {
		this.id=id;
		this.username = username;
		this.password = password;
	}

	public Object getUsername() {
		return username;
	}

	public Object getPassword() {
		return password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}


