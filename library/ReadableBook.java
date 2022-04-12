package bootcamp.oop.library;

import java.util.Random;

public class ReadableBook extends Book {

	public ReadableBook(String title, eType type, int quantity, Author author) {
		super(title, type, quantity, author);
		numOfOptions++;
	}

	@Override
	protected void printMenuOptions() {
		System.out.println("1. To read.");
	}

	@Override
	protected void handleInput(int input) {
		if (input != 1) {
			System.out.println("Invalid input.");
			return;
		}
		reading();
	}

	@Override
	public void reading() {
		Random random = new Random();
		System.out.println("To take: 1, To return: 2   :");
		int input = 1 + random.nextInt(2);
		System.out.print("Your choise: " + input);
		System.out.println("   <---------- your choise");

		switch (input) {
		case 1:
			subtractBookAndPrintResult();
			break;
		case 2:
			addBookAndPrintResult();
			break;
		default:
			System.out.println("Invalid input.");
		}
	}
}
