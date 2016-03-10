package edu.zju.chwl.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NThreadDatabaseReader {

	public static void main(String[] args) {
		NThreadDatabaseReader tt = new NThreadDatabaseReader();
		tt.getData();
	}

	public int getCount() {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "111111");
			String sql = "select count(id) from user";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			return count;
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
		return 0;
	}

	public void getData() {
		int count = getCount();
		int nThread = Runtime.getRuntime().availableProcessors() + 1;
		int mount = count / nThread + 1;
		CountDownLatch lacth = new CountDownLatch(nThread);

		ExecutorService executor = Executors.newFixedThreadPool(nThread);
		long a = System.currentTimeMillis();

		for (int i = 0; i < nThread; i++) {
			String sql = "select id,name,address from user limit " + i * mount
					+ "," + mount;
			executor.execute(new Task(sql, lacth));
		}
		executor.shutdown();
		try {
			lacth.await();
			long b = System.currentTimeMillis() - a;
			System.out.println("ResultSet Time:" + b + "ms");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	class Task implements Runnable {
		private String sql;
		private CountDownLatch lacth;

		Task(String sql, CountDownLatch lacth) {
			this.sql = sql;
			this.lacth = lacth;
		}

		@Override
		public void run() {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/test", "root", "111111");
				long a = System.currentTimeMillis();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String s = rs.getInt(1) + "\t" + rs.getString(2) + "\t"
							+ rs.getString(3);
					// System.out.println(s);
				}
				long b = System.currentTimeMillis() - a;
				System.out.println(Thread.currentThread().getName()
						+ "  ResultSet Time:" + b + "ms");
				lacth.countDown();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					rs.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
