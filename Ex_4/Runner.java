package javabootcamp.basic.Ex_4;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		// question 2 ===============================================================
		System.out.print("Enter a number: ");
		int num = scanner.nextInt();
		int result = 0, pow = 1;

		while (num > 0) {
			result += (num % 10) * pow;
			num /= 100;
			pow *= 10;
		}
		System.out.println("The new number is: " + result);

		// question 4 ===============================================================
		System.out.print("Enter ID number: ");
		int id = scanner.nextInt();
		int firstDigitFromRight = id % 10;
		int numOfDigits = 0, idCopy = id;

		while (idCopy > 0) {
			numOfDigits++;
			idCopy /= 10;
		}

		int finalDigit, weight, sum = 0, count = 0;
		id /= 10;
		for (int i = numOfDigits - 1; i > 0; i--) {
			weight = i % 2 == 0 ? 2 : 1;
			finalDigit = (id % 10) * weight;
			if (finalDigit > 9) {
				finalDigit = (finalDigit / 10) + (finalDigit % 10);
			}
			sum += finalDigit;
			id /= 10;
		}
		while (sum % 10 != 0) {
			sum++;
			count++;
		}

		String match = count == firstDigitFromRight ? "Good" : "Not Good";
		System.out.println("The first Digit From Right is " + match);

		// question 6 ===============================================================
		System.out.print("Enter number: ");
		num = scanner.nextInt();
		result = num;

		while (num > 0) {
			result *= 10;
			result += num % 10;
			num /= 10;
		}
		System.out.println("The new number is: " + result);

		// question 8 ===============================================================
		count = 0;
		float x, y, resultFloat;

		for (int denominator = 11; denominator < 100; denominator++) {
			for (int numerator = 10; numerator < denominator; numerator++) {
				// x / y
				x = numerator / 10;
				y = denominator % 10;
				resultFloat = numerator / (float) denominator;

				if (x / y == resultFloat) {
					System.out.printf("%d / %d == %.0f / %.0f\n", numerator, denominator, x, y);
					count++;
				}
			}
		}
		System.out.println("Count: " + count);

		
		// question 10 ===============================================================
		System.out.print("Enter a number: ");
		num = scanner.nextInt();
		System.out.print("Enter a digit: ");
		int digit = scanner.nextInt();
		int base = 1, currRes;
		
		result = 0;
		pow = base;
		for (int i = 0; i < digit; i++) {
			base *= 10;
		}
		while (num > 0) {
			currRes = 0;
			for (int i = 0; i < digit && num > 0; i++) {
				currRes *= 10;
				currRes += num % 10;
				num /= 10;
			}
			result += currRes * pow;
			pow *= base;
		}
		System.out.print("The new number: " + result);
		System.out.println(" ");

		// question 12 ===============================================================
		System.out.print("Enter a number: \n");
		num = scanner.nextInt();

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j < num; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}

		// question 14 ===============================================================
		System.out.print("Enter a number: ");
		num = scanner.nextInt();

		for (int i = 0; i < num * num; i++) {
			if (i % num == 0) {
				System.out.println(" ");
			}
			for (int j = 0; j < num * num; j++) {
				if (j % num == 0) {
					System.out.print("   ");
				}
				System.out.print("*");
			}
			System.out.println(" ");
		}

		// question 16 ===============================================================
		// TO DO

		scanner.close();
	}
}
