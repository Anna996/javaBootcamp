package course_organaizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserData {
	private final String ID;
	private Map<Integer, Course> courses;

	public UserData(String ID) {
		this.ID = ID;
		courses = new HashMap<>();
	}

	public void addCourse(Course course) {
		courses.put(course.getCOURSE_NUMBER(), course);
	}

	public String getID() {
		return ID;
	}

	public void printInfo() {
		Collection<Course> collectionsCourses = courses.values();

		System.out.println("User ID: " + ID);
		if (courses.size() == 0) {
			System.out.println("User doesn't have any courses.");
			return;
		}
		System.out.println("Courses:");
		printCourses(collectionsCourses);
		
		List<Integer> grades = getGrades(collectionsCourses);
		float average = calcAverage(grades);
		double standardDeviation = calcStandardDeviation(grades , average);
		
		System.out.printf("Average: %.2f\n", average);
		System.out.printf("Standard deviation: %.2f\n", standardDeviation);
	}

	private void printCourses(Collection<Course> courses) {
		for (Course course : courses) {
			System.out.println(course);
		}
	}

	private List<Integer> getGrades(Collection<Course> courses) {
		List<Integer> grades = new ArrayList<>(courses.size());

		for (Course course : courses) {
			grades.add(course.getGrade());
		}
		return grades;
	}

	private float calcAverage(List<Integer> grades) {
		float average = 0;

		for (int grade : grades) {
			average += grade;
		}
		average /= grades.size();
		return average;
	}

	private double calcStandardDeviation(List<Integer> grades, float average) {
		double standardDeviation = 0;
		
		for(int grade : grades) {
			standardDeviation += Math.pow(grade - average, 2);
		}
		return Math.sqrt(standardDeviation / grades.size());
	}
}
