package javabootcamp.basic.conditions;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		// ========================================================
		// is num dividable by 1, 2, 3, and 4

		System.out.print("Please enter a number: ");
		int num = scanner.nextInt();
		final int DIVISOR = 12;
		String result = num % DIVISOR == 0 ? "" : " NOT";
		System.out.printf("%d is%s dividable by 1, 2, 3, and 4\n", num, result);
		System.out.println("GoodBye!");

		// ========================================================
		// is numToCheck in the range of two other numbers

		System.out.println("Enter three digits:");
		int numToCheck = scanner.nextInt();
		int min = scanner.nextInt();
		int max = scanner.nextInt();

		// swap
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}

		String result2;
		if (numToCheck < min)
			result2 = "smaller than";
		else if (numToCheck > max)
			result2 = "greater than";
		else
			result2 = "in";
		System.out.printf("%d is %s the range %d to %d", numToCheck, result2, min, max);

		// ========================================================
		// Calc the date

		System.out.print("Enter a year: ");
		int year = scanner.nextInt();

		if (year < 0) {
			System.out.println("Invalid year value");
		} else {
			System.out.print("Enter a month: ");
			int month = scanner.nextInt();
			if (month < 1 || month > 12) {
				System.out.println("Invalid month value");
			} else {
				int numOfDays;
				switch (month) {
				case 2:
					numOfDays = (year % 4 == 0) ? 28 : 29;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					numOfDays = 30;
					break;
				default:
					numOfDays = 31;
				}

				String name = "";
				switch (month) {
				case 1:
					name = "January ";
					break;
				case 2:
					name = "February";
					break;
				case 3:
					name = "March";
					break;
				case 4:
					name = "April";
					break;
				case 5:
					name = "May";
					break;
				case 6:
					name = "June";
					break;
				case 7:
					name = "July";
					break;
				case 8:
					name = "August";
					break;
				case 9:
					name = "September";
					break;
				case 10:
					name = "October";
					break;
				case 11:
					name = "November ";
					break;
				case 12:
					name = "December";
					break;
				}
				System.out.printf("%s %d has %d days", name, year, numOfDays);
			}
		}

		scanner.close();
	}
}
