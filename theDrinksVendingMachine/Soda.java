package theDrinksVendingMachine;

/**
 * An abstract class that represents a Soda drink.
 * @author Anna Aba
 *
 */
public abstract class Soda extends Cold {
	private Container container;

	public Soda(int volume, int temperature, int price, Ingredient mainIngrediant, Container container) {
		super(volume, temperature, price, mainIngrediant);
		setContainer(container);
	}

	/**
	 * Set the soda container.
	 * @param container The soda container.
	 */
	private void setContainer(Container container) {
		this.container = container;
	}

	@Override
	public String toString() {
		return super.toString() + ", container=" + container;
	}
}
