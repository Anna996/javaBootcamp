package course_organaizer;

public class Course {
	private final int COURSE_NUMBER;
	private static int courseCounter = 0;
	private String name;
	private String schoolName;
	private int grade;
	
	public Course(String name, String schoolName, int grade) {
		COURSE_NUMBER = ++courseCounter;
		setName(name);
		setSchoolName(schoolName);
		setGrade(grade);
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	private void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getCOURSE_NUMBER() {
		return COURSE_NUMBER;
	}
	
	public int getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Course [COURSE_NUMBER=" + COURSE_NUMBER + ", name=" + name + ", schoolName=" + schoolName + ", grade="
				+ grade + "]";
	}
}
