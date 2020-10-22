package project_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
	//Field
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	private String user = "scott";
	private String pass = "tiger";
	
	public Connection conn;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	//Constructor
	public DBConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1----------->> 靛扼捞滚 肺爹 己傍");
			
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("2----------->> Connection 积己");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Statement 按眉 积己
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			System.out.println("3----------->> Statement 积己");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//PreparedStatement 按眉 积己
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("3----------->> PreparedStatement 积己");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//按眉 close
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			System.out.println("6----------->> 按眉 close 肯丰");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}//class
