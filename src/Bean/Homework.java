package Bean;

import java.sql.Timestamp;

public class Homework {
	public Homework() { }
	private Integer id;//不是homeworkId
	private String title;
	private String content;
	private Timestamp finishTime;
	private String teacherName;
	private int teacherId;
	private String couseName;


	private Integer type;
	private String answer;

	public int getType(){return type;}
	public void setType(Integer type){this.type = type;}
	public String getAnswer(){return answer;}
	public void setAnswer(String answer){this.answer = answer;}

	public Integer getId() {
		return id;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCouseName() {
		return couseName;
	}
	public void setCouseName(String couseName) {
		this.couseName = couseName;
	}

}
