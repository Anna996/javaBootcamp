package multithreaded_client_server.ex5_expenses_tracking;

import java.time.LocalDateTime;

public class Expense {
	private LocalDateTime timestamp;
	private double amount;
	private Category category;

	public Expense(LocalDateTime timestamp, Category category, double amount ) {
		this.timestamp = timestamp;
		this.category = category;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Expense [timestamp=" + timestamp + ", amount=%.2f".formatted(amount) + ", category=" + category + "]";
	}
}
