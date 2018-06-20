package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.WorkClass;

public class HomeworkClass {
	
	//ͨ��༶ID�����ҵID
	public ArrayList<Integer> findHomework(Integer classId) {
		ArrayList<Integer> homeworkIds = new ArrayList<Integer>();
		String sql = "select * from homeworkclass";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				Integer classIdInteger = rs.getInt("classId");
				 if (classIdInteger.equals(classId)) {
					 homeworkIds.add(rs.getInt("homeworkId") );
				 }
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return homeworkIds;
	}

	//������ҵ�༶������ϵ
	public void insertHomeworkClass(WorkClass workclass)
	{
		String sql = "insert into homeworkclass ( homeworkId, classId )values(?,?)";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1,workclass.getHomeworkId());
			dbConnect.setInt(2, workclass.getClassId());
			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//根据作业号修改班级
	public void updateHomeworkClass(int classId,int homeworkId)
	{
		String sql = "update homeworkclass set classId=? where homeworkId=?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1,classId);
			dbConnect.setInt(2, homeworkId);
			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteHomeworkClass(int homeworkId)
	{
		String sql = "delete from homeworkclass where homeworkId = ?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, homeworkId);
			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public WorkClass getHomeworkClassByHomeworkId(int homeworkId)
	{
		String sql = "select * from homeworkclass where homeworkId = ?";
		WorkClass hc = new WorkClass();
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, homeworkId);
			ResultSet rs = dbConnect.executeQuery();
			while (rs.next()) {
				hc.setHomeworkId(rs.getInt("homeworkId"));
				hc.setClassId(rs.getInt("classId"));
			}
			dbConnect.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return hc;
	}
	
}
