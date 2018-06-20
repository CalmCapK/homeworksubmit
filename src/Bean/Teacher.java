package Bean;

public class Teacher {
	private String name;
	private String pwd;
	private int teacherId;
	private int collegeId;
	private int sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSex() {
		return sex;
	}

}
