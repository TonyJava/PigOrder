package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class jdbc {
	private static String driverName="com.mysql.jdbc.Driver";
	private static String userName="root";
	private static String userPwd="123456";
	private static String dbName="pigorder";
	private static String url="";	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String url1="jdbc:mysql://localhost:3306/"+dbName;
	    String url2="?user="+userName+"&password="+userPwd;
	    String url3="&userUnicode=true&characterEncoding=UTF-8";
	    url=url1+url2+url3;
	    Class.forName(driverName);
	    return DriverManager.getConnection(url);
	}
	public static void free(Connection conn,Statement stmt,ResultSet rs) throws SQLException{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}
}

