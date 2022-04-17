package theDrinksVendingMachine;

/**
 * Represents a sprite drink.
 * @author Anna Aba
 *
 */
public class Sprite extends Soda {
	private final static int VOLUME = 200;
	private final static int TEMPERATURE = 3;
	private final static int PRICE = 15;

	public Sprite() {
		super(VOLUME, TEMPERATURE, PRICE, Ingredient.LEMON, Container.BOTTLE);
	}

	/**
	 * Print the Drink name to the console.
	 */
	@Override
	protected void printHotDrinkName() {
		System.out.println("Sprite...");		
	}
}
