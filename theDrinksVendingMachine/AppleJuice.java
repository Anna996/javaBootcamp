package theDrinksVendingMachine;

/**
 * Represents an apple juice drink.
 * @author Anna Aba
 *
 */
public class AppleJuice extends Soft {
	private final static int VOLUME = 180;
	private final static int TEMPERATURE = 5;
	private final static int PRICE = 18;
	
	public AppleJuice() {
		super(VOLUME, TEMPERATURE, PRICE, Ingredient.APPLE, State.PASTEURIZED);
	}

	/**
	 * Print the Drink name to the console.
	 */
	@Override
	protected void printHotDrinkName() {
		System.out.println("Apple Juice...");	
	}
}
