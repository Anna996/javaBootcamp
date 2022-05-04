package course_organaizer;

import java.util.HashMap;
import java.util.Map;

public class CourseOrganaizer {
	Map<String, UserData> users;

	public CourseOrganaizer() {
		users = new HashMap<>();
	}

	public void addUser(String userId) {
		users.put(userId, new UserData(userId));
	}

	public void addCourse(String userId, String name, String schoolName, int grade) {
		if (!users.containsKey(userId)) {
			System.out.println("Invalid ID");
		} else {
			UserData user = users.get(userId);
			user.addCourse(new Course(name, schoolName, grade));
		}
	}

	public void addCourse(String userId, String name, String schoolName) {
		this.addCourse(userId, name, schoolName, 0);
	}

	public void printUserInfo(String userId) {
		if (!users.containsKey(userId)) {
			System.out.println("Invalid ID");
		} else {
			UserData user = users.get(userId);
			user.printInfo();
		}
	}
}
