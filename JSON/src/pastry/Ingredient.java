package pastry;

public class Ingredient {
	private String name;
	private float weight;

	public Ingredient() {
		super();
	}

	public Ingredient(String name, float weight) {
		this.name = name;
		this.weight = weight;
	}

	public Ingredient(String name, int weight) {
		this(name, (float) weight);
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", weight=" + weight + "]";
	}
}
