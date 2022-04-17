package theDrinksVendingMachine;

/**
 * An abstract class that represents a coffee-based hot drink.
 * @author Anna Aba
 *
 */
public abstract class CoffeeBased extends Hot {
	private int numOfShots;
	private int shotVolume;
	private int milkQuantity;
	private final static Base COFFEE_BASE = Base.COFFEE;

	public CoffeeBased(int temperature, int price, int sugarSpoons, int shotVolume, int numOfShots, int milkQuantity) {
		super(numOfShots * shotVolume + milkQuantity, temperature, price, COFFEE_BASE, sugarSpoons);
		setNumOfShots(numOfShots);
		setMilkQuantity(milkQuantity);
		setShotVolume(shotVolume);
	}

	/**
	 * Set the number shots of espresso.
	 * @param numOfShots The espresso number of shots.
	 */
	private void setNumOfShots(int numOfShots) {
		this.numOfShots = numOfShots;
	}

	/**
	 * Set the volume of the espresso shot.
	 * @param shotVolume The volume of the espresso shot.
	 */
	private void setShotVolume(int shotVolume) {
		this.shotVolume = shotVolume;
	}

	/**
	 * Set the milk quantity.
	 * @param milkQuantity The milk quantity.
	 */
	private void setMilkQuantity(int milkQuantity) {
		this.milkQuantity = milkQuantity;
	}

	@Override
	public String toString() {
		return super.toString() + ", numOfShots=" + numOfShots + ", shotVolume=" + shotVolume + ", waterQuantity="
				+ numOfShots * shotVolume + ", milkQuantity=" + milkQuantity;
	}

	/**
	 * Get the amount of milk to consume from the machine.
	 */
	@Override
	protected int getMilkVolume() {
		return milkQuantity;
	}

	/**
	 *  Get the amount of water to consume from the machine.
	 */
	@Override
	protected int getWaterVolume() {
		return numOfShots * shotVolume;
	}
}
