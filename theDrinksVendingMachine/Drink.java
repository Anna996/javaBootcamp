package theDrinksVendingMachine;

/**
 * An abstract class that represents a drink.
 * @author Anna Aba
 *
 */
public abstract class Drink implements Produceable {
	protected int volume;
	private int temperature;
	private int price;
	private int minTemperature;
	private int maxTemperature;
	public static int minVolume;
	public static int maxVolume;

	static {
		minVolume = 50;
		maxVolume = 200;
	}

	public Drink(int volume, int temperature, int price, int minTemperature, int maxTemperature) {
		setMinAndMaxTemperature(minTemperature, maxTemperature);
		setVolume(volume);
		setTemperature(temperature);
		setPrice(price);
	}

	/**
	 * Set the volume.
	 * @param volume The value should be between minVolume and maxVolume.
	 */
	private void setVolume(int volume) {
		this.volume = volume >= minVolume && volume <= maxVolume ? volume : minVolume;
	}

	/**
	 * Set the temperature.
	 * @param temperature The value should be between minTemperature and maxTemperature.
	 */
	private void setTemperature(int temperature) {
		this.temperature = temperature >= minTemperature && temperature <= maxTemperature ? temperature
				: minTemperature;
	}

	/**
	 * Set the price.
	 * @param price The price of the drink.
	 */
	private void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Set the minimum temperature and maximum temperature.
	 * @param minTemperature The minimum temperature the drink should be.
	 * @param maxTemperature The maximum temperature the drink should be.
	 */
	private void setMinAndMaxTemperature(int minTemperature, int maxTemperature) {
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
	}

	@Override
	public String toString() {
		return "volume=" + volume + ", temperature=" + temperature + ", price=" + price;
	}

	/**
	 * Preparation of a drink. Print the drink details to the console. Ask the
	 * machine to supply the amount of water and milk needed for the drink.
	 */
	@Override
	public void produce() {
		printHotDrinkName();
		System.out.println(this);

		int waterVolume = getWaterVolume();
		int milkVolume = getMilkVolume();
		VendingMachine.consumeLiquid(waterVolume, milkVolume);
	}

	/**
	 * Get the amount of milk to consume from the machine.
	 * @return milk quantity.
	 */
	protected abstract int getMilkVolume();

	/**
	 * Get the amount of water to consume from the machine.
	 * @return water quantity.
	 */
	protected abstract int getWaterVolume();

	/**
	 * Print the Drink name to the console.
	 */
	protected abstract void printHotDrinkName();
}
