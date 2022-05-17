package pastry;

import java.util.List;

public class Pastry {
	private String name;
	private int calories;
	private Label label;
	private List<Ingredient> ingredients;

	public Pastry() {
	}

	public Pastry(String name, int calories, Label label, List<Ingredient> ingredients) {
		this.name = name;
		this.calories = calories;
		this.label = label;
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Pastry [name=" + name + ", calories=" + calories + ", label=" + label + ", ingredients=" + ingredients
				+ "]";
	}

	public enum Label {
		DAIRY, MEAT, PARVE
	}
}
