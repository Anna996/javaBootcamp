package bootcamp.oop.library;

import java.util.Random;

public abstract class Book implements IRead {
	protected String title;
	protected eType type;
	protected int quantity;
	protected Author author;
	protected int numOfOptions;

	public Book(String title, eType type, int quantity, Author author) {
		this.title = title;
		this.type = type;
		this.quantity = quantity;
		this.author = author;
		numOfOptions = 0;
	}

	public void approach() {
		Random random = new Random();
		System.out.println("===" + title + "===");
		System.out.println("You can:");
		printMenuOptions();

		int input = 1 + random.nextInt(numOfOptions);
		System.out.print("Your choise: " + input);
		System.out.println("   <---------- your choise");
		handleInput(input);
	}

	protected void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	protected boolean subtractBookAndPrintResult() {
		if (quantity > 0) {
			setQuantity(quantity - 1);
			System.out.println("Success!");
			return true;
		}
		System.out.println("Sorry. There is no available Books.");
		return false;
	}

	protected void addBookAndPrintResult() {
		setQuantity(quantity + 1);
		System.out.println("Success!");
	}

	protected abstract void printMenuOptions();

	protected abstract void handleInput(int input);
}
