package multithreaded_client_server.ex5_expenses_tracking;

public enum Category {
	FOOD, CLOTHING, UTILITIES, TRANSPORTATION;

	public static Category getVal(int i) {
		return Category.values()[i];
	}
	
	public static int getSize() {
		return Category.values().length;
	}
}
