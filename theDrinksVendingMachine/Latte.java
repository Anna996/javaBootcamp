package theDrinksVendingMachine;

/**
 * Represents a latte drink.
 * @author Anna Aba
 *
 */
public class Latte extends CoffeeBased {
	private final static int SHOT_VOLUME = 50;
	private final static int TEMPERATURE = 65;
	private final static int PRICE = 18;
	private final static int SUGAR_SPOONS = 3;
	private final static int NUM_OF_SHOTS = 1;
	private final static int MILK_QUANTITY = 100;

	public Latte() {
		super(TEMPERATURE, PRICE, SUGAR_SPOONS, SHOT_VOLUME, NUM_OF_SHOTS, MILK_QUANTITY);
	}
	
	/**
	 * Print the Drink name to the console.
	 */
	@Override
	protected void printHotDrinkName() {
		System.out.println("Latte...");
	}
}
