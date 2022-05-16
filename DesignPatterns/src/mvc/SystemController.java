package mvc;

public class SystemController {
	private SystemView view;
	private StudentModel model;

	public SystemController(SystemView view) {
		this.view = view;
	}

	public void startSystem() {
		view.showWelcomeTitle();

		String id = view.askForID();
		String firstName = view.askForFirstName();
		String lastName = view.askForLastName();

		this.model = new StudentModel(id, firstName, lastName);

		int[] grades = new int[] { view.askForGrade(), view.askForGrade(), view.askForGrade() };

		float average = model.calcAverage(grades);

		view.printStudentType(model.getStudentType(average));

		view.close();
	}
}
