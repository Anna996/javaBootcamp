package bootcamp.oop.library;

public class PurchasableBook extends BorrowableBook implements IPurchase {

	protected int price;

	public PurchasableBook(String title, eType type, int quantity, Author author, int totalDaysAllowed, int price) {
		super(title, type, quantity, author, totalDaysAllowed);
		setPrice(price);
		numOfOptions++;
	}

	private void setPrice(int price) {
		this.price = price;
	}

	@Override
	protected void printMenuOptions() {
		super.printMenuOptions();
		System.out.println("3. To purchase.");
	}

	@Override
	protected void handleInput(int input) {
		if (input == 3) {
			purchasing();
		} else {
			super.handleInput(input);
		}
	}

	@Override
	public void purchasing() {
		if (subtractBookAndPrintResult()) {
			System.out.println("The price is: " + price);
		}
	}
}
