package javabootcamp.basic.user_input;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number:");
		int num = scanner.nextInt();
		System.out.println("The num is:" + num);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// question 1
		// calculate the circumference scope and the circle area

		final float PIE = 3.14f;
		System.out.print("Please enter radius: ");
		int radius = scanner.nextInt();
		float circumference = 2 * PIE * radius;
		float area = PIE * radius * radius;
		System.out.printf("The circumference is: %f and the area is: %f", circumference, area);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// question 2
		// calculate an toast order

		int toast = 12, sum = toast;

		System.out.println("Please add extras:\n");

		System.out.println("Enter 2 - YES , 0 - NO");
		System.out.print("mashrooms: ");
		sum += scanner.nextInt();
		System.out.print("olive: ");
		sum += scanner.nextInt();
		System.out.print("corn: ");
		sum += scanner.nextInt();
		System.out.print("otherCheap: ");
		sum += scanner.nextInt();

		System.out.println("Enter 3 - YES , 0 - NO");
		System.out.print("bulgarit: ");
		sum += scanner.nextInt();
		System.out.print("extraCheese: ");
		sum += scanner.nextInt();
		System.out.print("otherExpensive: ");
		sum += scanner.nextInt();

		System.out.println("The cost is: " + sum);

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// question 3
		// calculate furniture order

		int furnitureCost, destenation, numOfFloor, weight;
		System.out.print("Enter furniture cost: ");
		furnitureCost = scanner.nextInt();
		System.out.print("Enter furniture weight: ");
		weight = scanner.nextInt();
		System.out.print("Enter destenation: ");
		destenation = scanner.nextInt();
		System.out.print("Enter floor number: ");
		numOfFloor = scanner.nextInt();

		final int TIP = 10, KM = 5;
		int total = furnitureCost + numOfFloor * weight + destenation * KM + furnitureCost * TIP / 100;
		System.out.println("Total coast: " + total);

		scanner.close();
	}
}
