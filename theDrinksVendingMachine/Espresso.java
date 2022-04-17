package theDrinksVendingMachine;

/**
 * Represents an espresso drink.
 * @author Anna Aba
 *
 */
public class Espresso extends CoffeeBased {
	private final static int SHOT_VOLUME = 50;
	private final static int TEMPERATURE = 85;
	private final static int PRICE = 12;
	private final static int SUGAR_SPOONS = 0;
	private final static int NUM_OF_SHOTS = 1;
	private final static int MILK_QUANTITY = 0;

	public Espresso() {
		super(TEMPERATURE, PRICE, SUGAR_SPOONS, SHOT_VOLUME, NUM_OF_SHOTS, MILK_QUANTITY);
	}

	/**
	 * Print the Drink name to the console.
	 */
	@Override
	protected void printHotDrinkName() {
		System.out.println("Espresso...");		
	}
}
