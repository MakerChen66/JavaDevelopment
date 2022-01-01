package system_of_database;



public class User_Of_Students {
	
	private String id;
	private String password;
	
	public User_Of_Students() {
	}
	
	
	public User_Of_Students(String id,String password) {
		this.id = id;
		this.password = password;
	}


	public Object getPassword() {
		return password;
	}

	public String getId() {
		return id;
	}

}


