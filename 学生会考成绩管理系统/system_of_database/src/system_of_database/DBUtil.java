package system_of_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Connection getConnection() throws ClassNotFoundException,
			SQLException,InstantiationException,IllegalAccessException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/exam_of_students?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			return con;
		} catch(Exception e) {
			throw new SQLException("驱动错误或连接失败！");
		}
	}
	
	public ResultSet executeQuery(String preparedsql,Object[] param) {
		try {
			ps = con.prepareStatement(preparedsql);
			if(param != null) {
				for(int i=0;i<param.length;i++) {
					ps.setNString(i+1,(String) param[i]);
				}
			}
			rs = ps.executeQuery();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
	
	public int executeUpdate(String preparedsql,Object[] param) {
		int num = 0;
		try {
			ps = con.prepareStatement(preparedsql);
			if(param != null) {
				for(int i=0;i<param.length;i++) {
					ps.setNString(i+1, (String)param[i]);
				}
			}
			num = ps.executeUpdate();
		} catch(Exception en) {
			en.printStackTrace();
		}
		return num;
	}
	
	public void closeAll() {
		if(rs != null) {
			try {
				rs.close();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			} catch(SQLException eh) {
				eh.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch(SQLException eg) {
				eg.printStackTrace();
			}
	}

  }
}

