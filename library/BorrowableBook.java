package bootcamp.oop.library;

public class BorrowableBook extends ReadableBook implements IBorrow {

	protected int totalDaysAllowed;

	public BorrowableBook(String title, eType type, int quantity, Author author, int totalDaysAllowed) {
		super(title, type, quantity, author);
		setTotalDaysAllowed(totalDaysAllowed);
		numOfOptions++;
	}

	private void setTotalDaysAllowed(int totalDaysAllowed) {
		this.totalDaysAllowed = totalDaysAllowed;
	}

	@Override
	protected void printMenuOptions() {
		super.printMenuOptions();
		System.out.println("2. To borrow.");
	}

	@Override
	protected void handleInput(int input) {
		if (input == 2) {
			borrowing();
		} else {
			super.handleInput(input);
		}
	}

	@Override
	public void borrowing() {
		super.reading();
	}
}
