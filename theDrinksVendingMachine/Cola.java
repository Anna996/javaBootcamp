package theDrinksVendingMachine;

/**
 * Represents a cola drink.
 * @author Anna Aba
 *
 */
public class Cola extends Soda {
	private final static int VOLUME = 200;
	private final static int TEMPERATURE = 2;
	private final static int PRICE = 15;

	public Cola() {
		super(VOLUME, TEMPERATURE, PRICE, Ingredient.COLA, Container.CAN);
	}

	/**
	 * Print the Drink name to the console.
	 */
	@Override
	protected void printHotDrinkName() {
		System.out.println("Cola...");		
	}
}
