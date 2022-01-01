package system_of_database;

import java.sql.ResultSet; 
import system_of_database.DBUtil;
import system_of_database.User_Of_Administration;

public class UserService_Of_Administration {
	
	public UserService_Of_Administration() {
	}
	
	public User_Of_Administration findUserByName(String userName) {
		DBUtil db = new DBUtil();
		User_Of_Administration user = null;
		try {
			db.getConnection();
			String sql = "select * from information_of_Administration where name = ?";
			Object[] param =  new Object[] {userName};
			ResultSet rs = db.executeQuery(sql,param);
			if(rs.next()) {
				user = new User_Of_Administration(rs.getString(2),rs.getString(3));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll();
		}
		return user;
	}

}


