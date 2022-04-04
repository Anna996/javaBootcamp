package javabootcamp.basic.Ex_2a;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		// question 1
		// ==================================================================================
		System.out.print("Enter your age: ");
		int age = scanner.nextInt();
		String ageType = age < 18 ? "minor" : "adult";
		System.out.printf("You are %s\n", ageType);

		// question 3
		// ==================================================================================
		System.out.print("Enter a double digit number: ");
		int doubleDigitNumber = scanner.nextInt();
		String equal = (doubleDigitNumber / 10 == doubleDigitNumber % 10) ? "" : "NOT ";
		System.out.printf("%d is %sequal", doubleDigitNumber, equal);

		// question 5
		// ==================================================================================
		System.out.print("Enter a double digit number: ");
		int doubleDigitNumber2 = scanner.nextInt();
		String isFollowing = "NOT ";

		if ((doubleDigitNumber2 / 10) + 1 == doubleDigitNumber2 % 10)
			isFollowing = "";

		System.out.printf("%d is %sfollowing number", doubleDigitNumber2, isFollowing);

		// question 7
		// ==================================================================================
		System.out.print("Enter MAX tank: ");
		int maxTank = scanner.nextInt();
		System.out.print("Enter current fuel: ");
		int currentFuel = scanner.nextInt();
		String shouldRefillTankStr = currentFuel <= maxTank * 0.15 ? "SHOULD" : "dont have to";
		System.out.printf("You %s refill your tank", shouldRefillTankStr);

		// question 9
		// ==================================================================================
		System.out.print("Enter a date (8 digits): ");
		int date = scanner.nextInt();
		int year = date % 10000;
		date /= 10000;
		int month = date % 100;
		date /= 100;
		int day = date;
		System.out.printf("The year is %d , the month is %d, and the day is %d.", year, month, day);
	}

}
