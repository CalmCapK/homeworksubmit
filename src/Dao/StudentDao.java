package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Bean.Student;

public class StudentDao {

	public void insert(Student student) {
		String sql = "insert into student (name, pwd, studentId, classId, major, grade, sex, collegeId)values(?,?,?,?,?,?,?,?)";
		try {
			DBConnect dbConnect = new DBConnect(sql);

			dbConnect.setString(1, student.getName());
			dbConnect.setString(2, student.getPwd());
			System.out.println("in studentDao: " + student.getPwd());
			dbConnect.setInt(3, student.getStudentId());
			dbConnect.setInt(4, student.getClassId());
			dbConnect.setString(5, student.getMajor());
			dbConnect.setInt(6, student.getGrade());
			dbConnect.setInt(7, student.getSex());
			dbConnect.setInt(8, student.getCollege());			

			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Object bean) {
		

	}

	public void delete(Object PKey) {
		// TODO Auto-generated method stub

	}

	public String find(String studentId) {
		String sql = "select * from student";
		String pwdString = new String();
		try {
			DBConnect dbConnect = new DBConnect(sql);
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				String studentIdString = rs.getString("studentId");	
				 if (studentIdString.equals(studentId)) {
					 pwdString = rs.getString("pwd");	
					 System.out.println("pwd = " + pwdString);  //ceshi
					 break;
				 }
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pwdString;
	}
	
	public Student findStudent(String studentId) {
		System.out.println("in studentDao " + studentId);
		String sql = "select * from student";
		Student student = new Student();
		try {
			DBConnect dbConnect = new DBConnect(sql);
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				String studentIdString = rs.getString("studentId");	
				 if (studentIdString.equals(studentId)) {
					 System.out.println("ssssssclassId " + rs.getInt("classId"));
					 student.setClassId(rs.getInt("classId"));
					 student.setCollege(rs.getInt("collegeId"));
					 student.setGrade(rs.getInt("grade"));
					 student.setMajor(rs.getString("major"));
					 student.setName(rs.getString("name"));
					 student.setSex(rs.getInt("sex"));
					 student.setPwd( rs.getString("pwd"));
					 return student;
				 }
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public List findExecutingSQL(String sql, Object[] sqlParams) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateBystudentId(Student student,String studentId) {
		String sql = "update student set name=?, pwd=?, classId=?, major=?, grade=?, sex=?, collegeId=? where studentId=?";
		try {
			DBConnect dbConnect = new DBConnect(sql);

			dbConnect.setString(1, student.getName());
			dbConnect.setString(2, student.getPwd());
			dbConnect.setInt(3, student.getClassId());
			dbConnect.setString(4, student.getMajor());
			dbConnect.setInt(5, student.getGrade());
			dbConnect.setInt(6, student.getSex());
			dbConnect.setInt(7, student.getCollege());			
			dbConnect.setString(8, studentId);
			
			System.out.println("update: "+student.getName());
			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
