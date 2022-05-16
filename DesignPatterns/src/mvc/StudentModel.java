package mvc;

public class StudentModel {
	private final String ID;
	private String firstName;
	private String lastName;
	private final int EXCELLENT_AVERAGE = 90;
	
	public StudentModel() {
		this(null,null,null);
	}

	public StudentModel(String ID, String firstName, String lastName) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public float calcAverage(int... grades) {
		int sum = 0;
		for (int grade : grades) {
			sum += grade;
		}

		return sum / grades.length;
	}

	public String getStudentType(float average) {
		return average >= EXCELLENT_AVERAGE ? "an excellent" : "a great";
	}
}