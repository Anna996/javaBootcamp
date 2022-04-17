package theDrinksVendingMachine;

/**
 * Represents an orange juice drink.
 * @author Anna Aba
 *
 */
public class OrangeJuice extends Soft {
	private final static int VOLUME = 180;
	private final static int TEMPERATURE = 5;
	private final static int PRICE = 20;
	
	public OrangeJuice() {
		super(VOLUME, TEMPERATURE, PRICE, Ingredient.ORANGE, State.SQUEEZED);
	}

	/**
	 * Print the Drink name to the console.
	 */
	@Override
	protected void printHotDrinkName() {
		System.out.println("Orange Juice...");	
	}
}
