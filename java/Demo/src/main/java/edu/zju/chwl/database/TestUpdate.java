package edu.zju.chwl.database;

import java.sql.*;

public class TestUpdate {

	public static void main(String[] args) throws SQLException {
		sqlInsert();
		spInsert();
	}

	@SuppressWarnings("null")
	public static void sqlInsert() throws SQLException {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "111111");
			conn.setAutoCommit(false);
			String sql="update user set name=? where id=?";
			stmt =conn.prepareStatement(sql);
			long a=System.currentTimeMillis();
			for(int i=0;i<1000;i++){
				stmt.setString(1, "sql-update-name"+i);
				stmt.setInt(2, i+1);
				stmt.addBatch();
			}
			int[] updateCounts=stmt.executeBatch();
			conn.commit();
			long b=System.currentTimeMillis()-a;
			System.out.println("Batch update with sql string.Time:"+b+"ms");
			int sum=0;
			for(int item :updateCounts){
				sum+=item;
			}
			System.out.println("insert rows count:"+sum);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
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

	@SuppressWarnings("null")
	public static void spInsert() throws SQLException {
		ResultSet rs = null;
		CallableStatement stmt = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "111111");
			conn.setAutoCommit(false);
			stmt =conn.prepareCall("call updateData(?,?)");
			long a=System.currentTimeMillis();
			for(int i=0;i<1000;i++){
				stmt.setString(1, "sp-update-name"+i);
				stmt.setInt(2, i+1);
				stmt.addBatch();
			}
			int[] updateCounts=stmt.executeBatch();			
			conn.commit();
			long b=System.currentTimeMillis()-a;
			System.out.println("Batch update with stored procedure.Time:"+b+"ms");
			int sum=0;
			for(int item :updateCounts){
				sum+=item;
			}
			System.out.println("insert rows count:"+sum);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
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
