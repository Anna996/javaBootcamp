package javabootcamp.basic.user_input;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please enter a number:");
//		int num = scanner.nextInt();
//		System.out.println("The num is:" + num);

		// question 2 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		int toast = 12, sum = toast;

		System.out.print("Please add extras: ");
		String extras = scanner.next();

		while (!extras.contentEquals("0")) {
			if (extras.contentEquals("mashrooms") 
					|| extras.contentEquals("olive") 
					|| extras.contentEquals("corn")
					|| extras.contentEquals("cheep")) {
				sum += 2;
			} else if (extras.contentEquals("bulgarit") 
					|| extras.contentEquals("extraCheese")
					|| extras.contentEquals("expensive")) {
				sum += 3;
			}
			extras = scanner.next();
		}

		System.out.println("The cost is: " + sum);

		scanner.close();
	}

}
