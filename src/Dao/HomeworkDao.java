package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.Homework;
import Bean.Student;
import Bean.Teacher;

public class HomeworkDao {

	// 通过学生Id获得ClassId再获得homeworkId，从而得到属于该学生的作业们
	/**
	 * @param studentId
	 * @return
	 */
	public ArrayList<Homework> findByStudentId(String studentId) {

		// 获得班级作业Id链表
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.findStudent(studentId);
		HomeworkClass homeworkClass = new HomeworkClass();
		ArrayList<Integer> homeworkIds = homeworkClass.findHomework(student
				.getClassId());

		ArrayList<Homework> homeworks = new ArrayList<Homework>();

		try {
			for (Integer homeworkId : homeworkIds) {
				String sql = "select * from homework where homeworkId = ?";
				DBConnect dbConnect = new DBConnect(sql);
				dbConnect.setInt(1, homeworkId);
				ResultSet rs = dbConnect.executeQuery();
				while (rs.next()) {
					Homework homework = new Homework();
					String teacherId = rs.getString("teacherId");
					TeacherDao teacherDao = new TeacherDao();
					Teacher teacher = new Teacher();
					teacher = teacherDao.findById(teacherId);
					String teacherName = teacher.getName();
					homework.setTeacherName(teacherName);
					homework.setContent(rs.getString("content"));
					homework.setCouseName(rs.getString("courseName"));
					homework.setFinishTime(rs.getTimestamp("finishTime"));
					homework.setId(rs.getInt("homeworkId"));
					homework.setTeacherId(rs.getInt("teacherId"));
					homework.setTitle(rs.getString("title"));

					homework.setType(rs.getInt("type"));//
					homework.setAnswer(rs.getString("answer"));//
					homeworks.add(homework);
				}
				dbConnect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return homeworks;
	}

	//插入作业数据
	public void insert(Homework homework) {
		String sql = "insert into homework (title, content, finishTime, teacherId,type,answer)values(?, ?, ?, ?,?,?)";//
		try {
			DBConnect dbConnect = new DBConnect(sql);
			System.out.println("title " + homework.getTeacherId());

			dbConnect.setString(1, homework.getTitle());
			dbConnect.setString(2, homework.getContent());
			dbConnect.setTime(3, homework.getFinishTime());
			dbConnect.setInt(4, homework.getTeacherId());
			dbConnect.setInt(5, homework.getType());//
			dbConnect.setString(6,homework.getAnswer());//

			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 根据教师Id获得教师布置的作业情况
	public ArrayList<Homework> findByTeacherId(String teacherId) {

		// 获得老师姓名
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = new Teacher();
		teacher = teacherDao.findById(teacherId);
		String teacherName = teacher.getName();

		// 获得教师布置的作业列表
		String sql = "select * from homework where teacherId = ?";
		ArrayList<Homework> homeworks = new ArrayList<Homework>();
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(teacherId));
			ResultSet rs = dbConnect.executeQuery();
			while (rs.next()) {
				Homework homework = new Homework();
				homework.setTeacherId(Integer.parseInt(rs
						.getString("teacherId")));
				homework.setContent(rs.getString("content"));
				homework.setCouseName(rs.getString("courseName"));
				homework.setFinishTime(rs.getTimestamp("finishTime"));
				homework.setId(rs.getInt("homeworkId"));
				homework.setTeacherName(teacherName);
				homework.setTitle(rs.getString("title"));

				homework.setType(rs.getInt("type"));//
				homework.setAnswer(rs.getString("answer"));//
				homeworks.add(homework);
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return homeworks;
	}

	// �������¼����һ����ҵ��Id
	public int getLastId() {
		// ��ȡ��ҵ��Ϣ
		String sql = "select max(homeworkId) from homework";
		int homeworkId = -1;
		try {
			DBConnect dbConnect = new DBConnect(sql);
			ResultSet rs = dbConnect.executeQuery();
			while (rs.next()) {
				homeworkId = rs.getInt("max(homeworkId)");
				System.out.println("homeworkId=" + homeworkId);
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return homeworkId;
	}

	// 根据作业Id返回作业详情
	public Homework getByHomeworkId(String homeworkId) {
		Homework hm = new Homework();
		String sql = "select * from homework where homeworkId = ?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(homeworkId));
			ResultSet rs = dbConnect.executeQuery();
			while (rs.next()) {
				hm.setTeacherId(rs.getInt("teacherId"));
				hm.setContent(rs.getString("content"));
				hm.setCouseName(rs.getString("courseName"));
				hm.setFinishTime(rs.getTimestamp("finishTime"));

				hm.setType(rs.getInt("type"));//
				hm.setAnswer(rs.getString("answer"));//

				TeacherDao teacherDao = new TeacherDao();
				Teacher teacher = new Teacher();
				teacher = teacherDao.findById(rs.getInt("teacherId"));
				String teacherName = teacher.getName();
				hm.setTeacherName(teacherName);
				
				hm.setTitle(rs.getString("title"));
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hm;
	}
	
	// 根据作业Id返回作业详情
	public Homework getByHomeworkId(int homeworkId) {
		Homework hm = new Homework();
		String sql = "select * from homework where homeworkId = ?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, homeworkId);
			ResultSet rs = dbConnect.executeQuery();
			while (rs.next()) {
				hm.setTeacherId(rs.getInt("teacherId"));
				hm.setContent(rs.getString("content"));
				hm.setCouseName(rs.getString("courseName"));
				hm.setFinishTime(rs.getTimestamp("finishTime"));

				hm.setType(rs.getInt("type"));//
				hm.setAnswer(rs.getString("answer"));//

				TeacherDao teacherDao = new TeacherDao();
				Teacher teacher = new Teacher();
				teacher = teacherDao.findById(rs.getInt("teacherId"));
				String teacherName = teacher.getName();
				hm.setTeacherName(teacherName);
				
				hm.setTitle(rs.getString("title"));
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hm;
	}
	
	// 根据作业Id删除作业
	public void deleteByHomeworkId(String homeworkId) {
		String sql = "delete from homework where homeworkId = ?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setInt(1, Integer.parseInt(homeworkId));
			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 根据作业Id修改作业情况
	public void updateByHomeworkId(int homeworkId,Homework hm) {
		String sql = "update homework set title=?,content=?,finishTime=?,type=?,answer=? where homeworkId = ?";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			dbConnect.setString(1, hm.getTitle());
			dbConnect.setString(2, hm.getContent());
			dbConnect.setTime(3, hm.getFinishTime());
			dbConnect.setInt(4, hm.getType());//
			dbConnect.setString(5, hm.getAnswer());
			dbConnect.setInt(6, homeworkId);

			dbConnect.executeUpdate();
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
