package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Homework;
import Bean.HomeworkStudent;
import Bean.Student;


public class
HomeworkStudentDao {
	
	//提交作业
	public void insert(HomeworkStudent hs) {
		String sql = "insert into homeworkstudent (homeworkId, studentId, file, score) values(?,?,?,?)";
		try {
			DBConnect dbConnect = new DBConnect(sql);
	        System.out.println(hs.getHomeworkId()+" "+hs.getStudentId()+" "+hs.getScore()+" "+hs.getFile());
			dbConnect.setInt(1, hs.getHomeworkId());
			dbConnect.setInt(2, hs.getStudentId());
			dbConnect.setString(3, hs.getFile());
			dbConnect.setInt(4, hs.getScore());
			
			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	//通过作业Id获得作业情况
	public ArrayList<HomeworkStudent> findByHomeworktId(String homeworkId) {
		String sql = "select * from homeworkstudent where homeworkId = ?";
		ArrayList<HomeworkStudent> homeworks = new ArrayList<HomeworkStudent>();
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(homeworkId));
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				HomeworkStudent homework = new HomeworkStudent();
				Integer homeworkIdInteger = rs.getInt("homeworkId");
				homework.setHomeworkId(homeworkIdInteger);
				homework.setId(Integer.parseInt(rs.getString("id")));
				homework.setFile(rs.getString("file"));
				homework.setStudentId(rs.getInt("studentId"));
				homework.setScore(rs.getInt("score"));
				homeworks.add(homework);
			}			
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return homeworks;
	}
	
	//通过学生Id获得作业情况
	public ArrayList<HomeworkStudent> findByStudentId(String studentId) {
		String sql = "select * from homeworkstudent where studentId = ?";
		ArrayList<HomeworkStudent> homeworks = new ArrayList<HomeworkStudent>();
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(studentId));
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				HomeworkStudent homework = new HomeworkStudent();
				homework.setHomeworkId(rs.getInt("homeworkId"));
				homework.setId(Integer.parseInt(rs.getString("id")));
				homework.setFile(rs.getString("file"));
				homework.setStudentId(rs.getInt("studentId"));
				homework.setScore(rs.getInt("score"));
				homeworks.add(homework);
			}			
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return homeworks;
	}
	
	//根据homeworkId和studentId获得学生提交作业情况
	public ArrayList<HomeworkStudent> getHomeworkStudentByStudentIdHomeworkId(String homeworkId,String studentId)
	{
		String sql = "select * from homeworkstudent where homeworkId = ? and studentId = ?";
		ArrayList<HomeworkStudent> hmws=new ArrayList<HomeworkStudent>();		
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(homeworkId));
			dbConnect.setInt(2, Integer.parseInt(studentId));
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				HomeworkStudent hs=new HomeworkStudent();
				hs.setId(Integer.parseInt(rs.getString("id")));
				hs.setFile(rs.getString("file"));
				hs.setScore(rs.getInt("score"));
				hs.setHomeworkId(rs.getInt("homeworkId"));
				hmws.add(hs);
			}			
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hmws;
	}
	
	//根据homeworkId和studentId获得学生提交作业情况
	public ArrayList<HomeworkStudent> getHomeworkStudentByStudentIdHomeworkId(int homeworkId,String studentId)
	{
		String sql = "select * from homeworkstudent where homeworkId = ? and studentId = ?";
		ArrayList<HomeworkStudent> hmws=new ArrayList<HomeworkStudent>();		
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, homeworkId);
			dbConnect.setInt(2, Integer.parseInt(studentId));
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				HomeworkStudent hs=new HomeworkStudent();
				//System.out.println("113333333311111"+rs.getString("id"));
				hs.setId(Integer.parseInt(rs.getString("id")));
				//System.out.println("111111111111"+rs.getString("id"));
				hs.setFile(rs.getString("file"));
				hs.setScore(rs.getInt("score"));
				hs.setHomeworkId(rs.getInt("homeworkId"));
				hmws.add(hs);
			}			
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hmws;
	}
	
	//根据homeworkId和studentId获得学生作业成绩
	public int getScoreByStudentIdHomeworkId(int homeworkId,String studentId)
	{
		String sql = "select score from homeworkstudent where homeworkId = ? and studentId = ?";
		int score=-1;
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, homeworkId);
			dbConnect.setInt(2, Integer.parseInt(studentId));
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				score=rs.getInt("score");
			}			
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return score;
	}
	
	//根据id获得作业成绩
	public int getScoreByid(int id)
	{
		String sql = "select score from homeworkstudent where id = ?";
		int score=-1;
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, id);
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				score=rs.getInt("score");
			}			
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return score;
	}
	
	//根据id获得作业成绩
	public int getScoreByid(String id)
	{
		String sql = "select score from homeworkstudent where id = ?";
		int score=-1;
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(id));
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				score=rs.getInt("score");
			}			
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return score;
	}
	
	//通过作业Id更新作业分数
	public void updateScoreByid(String id,String score)
	{
		String sql = "update homeworkstudent set score = ? where id = ?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(score));
			dbConnect.setInt(2, Integer.parseInt(id));
			dbConnect.executeUpdate();			
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//通过作业Id更新作业分数
	public void updateScoreByid(int id,String score)
	{
		String sql = "update homeworkstudent set score = ? where id = ?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(score));
			dbConnect.setInt(2, id);
			dbConnect.executeUpdate();			
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//通过作业Id获得作业情况
	public HomeworkStudent getHomeworkStudentById(String id)
	{
		String sql = "select * from homeworkstudent where id = ?";
		HomeworkStudent hs=new HomeworkStudent();
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(id));
			ResultSet rs = dbConnect.executeQuery();
			while(rs.next())
			{
				hs.setId(Integer.parseInt(rs.getString("id")));
				hs.setFile(rs.getString("file"));
				hs.setScore(rs.getInt("score"));
				hs.setHomeworkId(rs.getInt("homeworkId"));
				hs.setStudentId(rs.getInt("studentId"));
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hs;
	}
	
	//通过作业Id更新作业详情
	public void updateHomeworkStudentById(String id,HomeworkStudent hs)
	{
		String sql = "update homeworkstudent set score = ?,file = ?,homeworkId = ?,studentId = ? where id = ?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, hs.getScore());
			dbConnect.setString(2, hs.getFile());
			dbConnect.setInt(3, hs.getHomeworkId());
			dbConnect.setInt(4, hs.getStudentId());
			dbConnect.setInt(5, Integer.parseInt(id));
			dbConnect.executeUpdate();			
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//通过作业Id删除作业
	public void deleteByid(String id) {
		String sql = "delete from homeworkstudent where id = ?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(id));
			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//通过homeworkId删除作业
	public void deleteByHomeworkId(String homeworkId) {
		String sql = "delete from homeworkstudent where homeworkId = ?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(homeworkId));
			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
