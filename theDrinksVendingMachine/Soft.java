package theDrinksVendingMachine;

/**
 * An abstract class that represents a Soft drink.
 * @author Anna Aba
 *
 */
public abstract class Soft extends Cold {
	private State state;

	public Soft(int volume, int temperature, int price, Ingredient mainIngrediant, State state) {
		super(volume, temperature, price, mainIngrediant);
		setState(state);
	}

	/**
	 * Set the soft drink state.
	 * @param state The soft drink state.
	 */
	private void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return super.toString() + ", state=" + state;
	}
}
