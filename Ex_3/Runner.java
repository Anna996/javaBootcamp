package javabootcamp.basic.Ex_3;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		// question 3
		// Give money for wedding
		// =============================================================
		int sumOfMoney;

		System.out.print("The couple are: Family - 1 Friends - 2 Other - 3 : ");
		int input = scanner.nextInt();

		switch (input) {
		case 1:
			sumOfMoney = 1000;
			break;
		case 2:
			sumOfMoney = 500;
			break;
		default:
			sumOfMoney = 250;
		}

		if (input != 1) {
			System.out.print("Do you know them more than 3 years? YES - 1 NO - 2 : ");
			input = scanner.nextInt();
			if (input == 1)
				sumOfMoney += 50;
			System.out.print("Is it takes to arrive the wedding more than one hour? YES - 1 NO - 2 : ");
			input = scanner.nextInt();
			if (input == 1)
				sumOfMoney -= 50;
		}
		System.out.println("You should pay: " + sumOfMoney);

		// question 7
		// Calc the final score for student at course
		// =============================================================

		System.out.print("Enter exam score: ");
		int examScore = scanner.nextInt();
		System.out.print("Enter average score of home assignments: ");
		int averageOfHomeAssignments = scanner.nextInt();
		System.out.print("Enter num of submitted tasks: ");
		int numOfTasksSubmitted = scanner.nextInt();

		int finalScore = 0;
		float precentage = 0;
		final int TO_PASS = 55;

		switch (numOfTasksSubmitted) {
		case 5:
		case 6:
			precentage = (examScore >= TO_PASS) ? 0.2f : 0;
			break;
		case 7:
		case 8:
			if (averageOfHomeAssignments <= examScore) {
				break;
			}
			if (examScore >= TO_PASS) {
				precentage = 0.3f;
			} else {
				precentage = averageOfHomeAssignments >= 80 ? 0.25f : 0.2f;
			}
		}

		if (numOfTasksSubmitted > 4) {
			finalScore = (int) (examScore * (1 - precentage) + averageOfHomeAssignments * precentage);
		}
		System.out.println("Final score is: " + finalScore);

		scanner.close();
	}
}
