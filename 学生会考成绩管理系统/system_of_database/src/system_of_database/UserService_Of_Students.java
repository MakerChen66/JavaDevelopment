package system_of_database;

import java.sql.ResultSet; 
import system_of_database.DBUtil;
import system_of_database.User_Of_Students;

public class UserService_Of_Students {
	
	public UserService_Of_Students() {
	}
	
	public User_Of_Students findUserByName(String userName) {
		DBUtil db = new DBUtil();
		User_Of_Students user = null;
		try {
			db.getConnection();
			String sql = "select * from information_of_students where id = ?";
			Object[] param =  new Object[] {userName};
			ResultSet rs = db.executeQuery(sql,param);
			if(rs.next()) {
				user = new User_Of_Students(rs.getString(1),rs.getString(2));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll();
		}
		return user;
	}

}


