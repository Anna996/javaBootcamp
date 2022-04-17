package theDrinksVendingMachine;

/**
 * Represents a hot chocolate drink.
 * @author Anna Aba
 *
 */
public class HotChocolate extends Hot {
	private final static Base BASE = Base.MILK;
	private final static int VOLUME = 150;
	private final static int TEMPERATURE = 70;
	private final static int PRICE = 8;
	private final static int SUGAR_SPOONS = 2;

	public HotChocolate() {
		super(VOLUME, TEMPERATURE, PRICE, BASE, SUGAR_SPOONS);
	}

	/**
	 * Get the amount of milk to consume from the machine.
	 */
	@Override
	protected int getMilkVolume() {
		return BASE == Base.MILK ? VOLUME : 0;
	}

	/**
	 * Get the amount of water to consume from the machine.
	 */
	@Override
	protected int getWaterVolume() {
		return BASE == Base.WATER ? VOLUME : 0;
	}

	/**
	 * Print the Drink name to the console.
	 */
	@Override
	protected void printHotDrinkName() {
		System.out.println("Hot Chocolate...");
	}
}
