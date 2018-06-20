package Bean;

public class HomeworkStudent {
	private int id;
	private Integer homeworkId;
	private int studentId;
	private String file;
	private int score=-1;

	public Integer getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(Integer homeworkId) {
		this.homeworkId = homeworkId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
