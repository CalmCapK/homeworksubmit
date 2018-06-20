package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.Teacher;

public class TeacherDao {
	
	//���teacherId�������
	public String findPwd(String teacherId) {
		String sql = "select * from teacher";
		String pwdString = new String();
		try {
			DBConnect dbConnect = new DBConnect(sql);
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				String studentIdString = rs.getString("teacherId");	
				 if (studentIdString.equals(teacherId)) {
					 pwdString = rs.getString("pwd");	
					 break;
				 }
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pwdString;
	}
	
	//��teacher���в������
	public void insert(Teacher teacher) {
		String sql = "insert into teacher (teacherName, pwd, teacherId, collegeId,sex)values(?,?,?,?,?)";
		try {
			DBConnect dbConnect = new DBConnect(sql);

			dbConnect.setString(1, teacher.getName());
			dbConnect.setString(2, teacher.getPwd());
			dbConnect.setInt(3, teacher.getTeacherId());	
			dbConnect.setInt(4, teacher.getCollegeId());
			dbConnect.setInt(5, teacher.getSex());
			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//�ɽ�ʦId��ý�ʦ��
	public Teacher findById(String teacherId)
	{
		//�ɽ�ʦID��ý�ʦ���
		Teacher teacher=new Teacher();
		String sql="select * from teacher where teacherId = ?";
		try {
			DBConnect dbC = new DBConnect(sql);
			dbC.setInt(1, Integer.parseInt(teacherId));
			ResultSet rs=dbC.executeQuery();
			while(rs.next())
			{
				teacher.setName(rs.getString("teacherName"));
				teacher.setPwd(rs.getString("pwd"));
				teacher.setTeacherId(Integer.parseInt(teacherId));
				teacher.setSex(rs.getInt("sex"));//
				teacher.setCollegeId(rs.getInt("collegeId"));//
			}
			dbC.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return teacher;
	}
	
	//�ɽ�ʦId��ý�ʦ��
	public Teacher findById(int teacherId)
	{
		//�ɽ�ʦID��ý�ʦ���
		Teacher teacher=new Teacher();
		String sql="select * from teacher where teacherId = ?";
		try {
			DBConnect dbC = new DBConnect(sql);
			dbC.setInt(1, teacherId);
			ResultSet rs=dbC.executeQuery();
			while(rs.next())
			{
				teacher.setName(rs.getString("teacherName"));
				teacher.setPwd(rs.getString("pwd"));
				teacher.setTeacherId(teacherId);
			}
			dbC.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return teacher;
	}
	//��teacher���в������
	public void updateByteacherId(Teacher teacher,String teacherId) {
		String sql = "update  teacher set teacherName=?, pwd=?, collegeId=?,sex=? where teacherId=?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setString(1, teacher.getName());
			dbConnect.setString(2, teacher.getPwd());
			dbConnect.setInt(3, teacher.getCollegeId());
			dbConnect.setInt(4, teacher.getSex());
			
			dbConnect.setInt(5, Integer.parseInt(teacherId));
			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
