package mvc;

import java.util.Scanner;

public class SystemView {
	private Scanner scanner;

	public SystemView() {
		scanner = new Scanner(System.in);
	}

	public void showWelcomeTitle() {
		System.out.println("Welcome to the system!");
	}
	
	public String askForID() {
		System.out.print("Please enter your ID: ");
		return scanner.next();
	}
	
	public String askForFirstName() {
		System.out.print("Please enter your first name: ");
		return scanner.next();
	}
	
	public String askForLastName() {
		System.out.print("Please enter your last name: ");
		return scanner.next();
	}
	
	public int askForGrade() {
		System.out.print("Please enter a grade: ");
		return scanner.nextInt();
	}
	
	public void printStudentType(String type) {
		System.out.println("You are " + type + " student!");
	}
	
	public void close() {
		scanner.close();
	}
}
