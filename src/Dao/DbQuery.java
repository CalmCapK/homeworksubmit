package Dao;

import java.sql.*;

public class DbQuery {
	public static void main(String[] argv) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/submit?useUnicode=true&characterEncoding=utf8", "root", "guo7315");
			String strsql = "select * from student where id=?";
			PreparedStatement pstmt = conn.prepareStatement(strsql,  ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				System.out.println("id = " + id + " 姓名 = " + name + " 密码 = " + pwd);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}	catch (Exception e) {
			e.printStackTrace();
		}
	}
}
