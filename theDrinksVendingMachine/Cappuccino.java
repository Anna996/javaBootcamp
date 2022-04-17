package theDrinksVendingMachine;

/**
 * Represents a cappuccino drink.
 * @author Anna Aba
 *
 */
public class Cappuccino extends CoffeeBased {
	private final static int SHOT_VOLUME = 75;
	private final static int TEMPERATURE = 90;
	private final static int PRICE = 15;
	private final static int SUGAR_SPOONS = 4;
	private final static int NUM_OF_SHOTS = 2;
	private final static int MILK_QUANTITY = 50;

	public Cappuccino() {
		super(TEMPERATURE, PRICE, SUGAR_SPOONS, SHOT_VOLUME, NUM_OF_SHOTS, MILK_QUANTITY);
	}

	/**
	 * Print the Drink name to the console.
	 */
	@Override
	protected void printHotDrinkName() {
		System.out.println("Cappuccino...");
	}
}
