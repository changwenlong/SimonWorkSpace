package edu.zju.chwl.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestResultSet {

	public static void main(String[] args) {
		testResultSet();

	}
	
	public static void testResultSet() {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "111111");
			conn.setAutoCommit(false);
			String sql="select id,name,address from user";
			long a=System.currentTimeMillis();
			stmt =conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				String s =rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3);
				//System.out.println(s);
			}
			long b=System.currentTimeMillis()-a;
			System.out.println("ResultSet Time:"+b+"ms");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
