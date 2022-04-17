package theDrinksVendingMachine;

/**
 * An abstract class that represents a hot drink.
 * @author Anna Aba
 *
 */
public abstract class Hot extends Drink {
	private Base base;
	private int sugarSpoons;
	protected static int minSugarSpoons;
	protected static int maxSugarSpoons;
	private final static int MIN_TEMPERATURE;
	private final static int MAX_TEMPERATURE;

	static {
		minSugarSpoons = 0;
		maxSugarSpoons = 5;
		MIN_TEMPERATURE = 60;
		MAX_TEMPERATURE = 90;
	}

	public Hot(int volume, int temperature, int price, Base base, int sugarSpoons) {
		super(volume, temperature, price, MIN_TEMPERATURE, MAX_TEMPERATURE);
		this.base = base;
		setSugarSpoons(sugarSpoons);
	}

	/**
	 * Set the number of sugar spoons to add to the drink.
	 * @param sugarSpoons The value should be between minSugarSpoons and maxSugarSpoons.
	 */
	protected void setSugarSpoons(int sugarSpoons) {
		this.sugarSpoons = sugarSpoons >= minSugarSpoons && sugarSpoons <= maxSugarSpoons ? sugarSpoons
				: minSugarSpoons;
	}

	@Override
	public String toString() {
		return super.toString() + ", base=" + base + ", sugarSpoons=" + sugarSpoons;
	}
}
