package edu.zju.chwl.database;

import java.sql.*;

public class TestInsert {

	public static void main(String[] args) throws SQLException {
		sqlInsert();
		//spInsert();
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
			String sql="insert into user(name,address) values(?,?)";
			stmt =conn.prepareStatement(sql);
			long a=System.currentTimeMillis();
			for(int i=0;i<600000;i++){
				stmt.setString(1, "test6-sql-name"+i);
				stmt.setString(2, "test6-sql-address"+i);
				stmt.addBatch();
			}
			int[] updateCounts=stmt.executeBatch();
			conn.commit();
			long b=System.currentTimeMillis()-a;
			System.out.println("Batch insert with sql string. Time:"+b+"ms");
			int sum=0;
			for(int item :updateCounts){
				sum+=item;
			}
			System.out.println("Insert rows count:"+sum);
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
			stmt =conn.prepareCall("call insertData(?,?)");
			long a=System.currentTimeMillis();
			for(int i=0;i<100;i++){
				stmt.setString(1, "sp-name"+i);
				stmt.setString(2, "sp-address"+i);
				stmt.addBatch();
			}
			int[] updateCounts=stmt.executeBatch();			
			conn.commit();
			long b=System.currentTimeMillis()-a;
			System.out.println("Batch insert with stored procedure. Time:"+b+"ms");
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
