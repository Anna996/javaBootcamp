package theDrinksVendingMachine;

/**
 * An abstract class that represents a cold drink.
 * @author Anna Aba
 *
 */
public abstract class Cold extends Drink {
	private Ingredient mainIngredient;
	private final static int MIN_TEMPERATURE;
	private final static int MAX_TEMPERATURE;

	static {
		MIN_TEMPERATURE = 2;
		MAX_TEMPERATURE = 5;
	}

	public Cold(int volume, int temperature, int price, Ingredient mainIngrediant) {
		super(volume, temperature, price, MIN_TEMPERATURE, MAX_TEMPERATURE);
		setMainIngrediant(mainIngrediant);
	}

	/**
	 * Set the main ingredient in the drink.
	 * @param mainIngredient Main ingredient in the drink.
	 */
	private void setMainIngrediant(Ingredient mainIngredient) {
		this.mainIngredient = mainIngredient;
	}

	@Override
	public String toString() {
		return super.toString() + ", mainIngrediant=" + mainIngredient;
	}

	/**
	 * Cold drink doesn't have a milk, so it returns 0.
	 */
	@Override
	protected int getMilkVolume() {
		return 0;
	}

	/**
	 * Get the amount of water to consume from the machine.
	 */
	@Override
	protected int getWaterVolume() {
		return volume;
	}
}
