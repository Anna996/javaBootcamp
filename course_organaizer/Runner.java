package course_organaizer;

public class Runner {

	public static void main(String[] args) {
		CourseOrganaizer organaizer = new CourseOrganaizer();
		String userId = "123";
		
		organaizer.addUser(userId);
		organaizer.addCourse(userId, "Math", "Atid",80);
		organaizer.addCourse(userId, "Sports", "Atid",90);
		organaizer.addCourse(userId, "Computers", "Atid",70);
		organaizer.printUserInfo(userId);
	}
}
