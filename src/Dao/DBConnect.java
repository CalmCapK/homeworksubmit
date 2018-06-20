package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DBConnect {
	private Connection conn = null;
	private PreparedStatement prepstmt = null;
	
	public DBConnect(String sql)throws SQLException {
		init();
		this.propareStatment(sql);
		System.out.println(sql);
	}
	
	public DBConnect(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		init();
		this.prepareStatment(sql, resultSetType, resultSetConcurrency);
	}

	void init() {
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			conn = DriverManager.getConnection("proxool.MySQL");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void propareStatment(String sql) throws SQLException {
		prepstmt = conn.prepareStatement(sql);
	}

	public void prepareStatment(String sql, int resultSetType,
			int resultSetConcurrenty) throws SQLException {
		prepstmt = conn.prepareStatement(sql, resultSetType,
				resultSetConcurrenty);
	}

	public ResultSet executeQuery() throws SQLException {
		if (prepstmt != null) {
			return prepstmt.executeQuery();
		} else {
			return null;
		}
	}
	
	public void executeUpdate() throws SQLException {
		if (prepstmt != null) {
			prepstmt.executeUpdate();
		}
	}

	public void close() throws SQLException {
		if (prepstmt != null) {
			prepstmt.close();
			prepstmt = null;
		}
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}

	public void setString(int index, String value) throws SQLException {
		prepstmt.setString(index, value);
	}
	
	public void setInt(int index, int value) throws SQLException {
		prepstmt.setInt(index, value);
	}
	
	public void setTime(int index, Timestamp timestamp) {
		try {
		prepstmt.setTimestamp(index, timestamp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
