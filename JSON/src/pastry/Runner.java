package pastry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pastry.Pastry.Label;

public class Runner {
	private static List<Pastry> pastryList;
	private static Map<Label, List<Pastry>> pastryMap;

	public static void main(String[] args) {

		initList();

		// serialization - pastry object
		Json.saveToJson(pastryList.get(0));

		// deserialization - pastry object
		System.out.println("The parsed pastry object:");
		Pastry parsedPastry = Json.parseToPastry();
		System.out.println(parsedPastry);

		// serialization - List of pastry objects
		Json.saveToJson(pastryList);

		// deserialization - List of pastry objects
		System.out.println("\nThe parsed pastry list:");
		List<Pastry> parsedPastryList = Json.parseToPastryList();
		parsedPastryList.forEach(System.out::println);

		initMap();

		// serialization - map
		Json.saveToJson(pastryMap);

		// deserialization - map
		System.out.println("\nThe parsed pastry map:");
		Map<Label, List<Pastry>> pastryMap = Json.parseToPastryMap();
		pastryMap.forEach((lable, pastryList)->{
			System.out.println(lable);
			pastryList.forEach(System.out::println);
			System.out.println("");
		});
	}

	public static void initList() {
		List<Ingredient> pizzaIngredients = Arrays.asList(
				new Ingredient("cheese", 50), 
				new Ingredient("sugar", 25.5f));
		List<Ingredient> spagettiIngredients = Arrays.asList(
				new Ingredient("meat", 200), 
				new Ingredient("soya", 6f));
		List<Ingredient> cakeIngredients = Arrays.asList(
				new Ingredient("chocolate", 21.5f),
				new Ingredient("sugar", 35.5f));

		pastryList = Arrays.asList(
				new Pastry("Pizza", 2000, Label.DAIRY, pizzaIngredients),
				new Pastry("Spagetti", 5000, Label.MEAT, spagettiIngredients),
				new Pastry("Cake", 1200, Label.PARVE, cakeIngredients));
	}

	public static void initMap() {
		List<Ingredient> pizzaIngredients = Arrays.asList(
				new Ingredient("cheese", 30), 
				new Ingredient("sugar", 25f));
		List<Ingredient> spagettiIngredients = Arrays.asList(
				new Ingredient("meat", 125), 
				new Ingredient("soya", 5.2f));
		List<Ingredient> cakeIngredients = Arrays.asList(
				new Ingredient("chocolate", 20f),
				new Ingredient("sugar", 30.5f));
		
		pastryMap = new HashMap<>();
		pastryMap.put(Label.DAIRY, Arrays.asList(pastryList.get(0), new Pastry("Italian Pizza", 2015, Label.DAIRY, pizzaIngredients)));
		pastryMap.put(Label.MEAT, Arrays.asList(pastryList.get(1), new Pastry("Spain Spagetti", 4910, Label.MEAT, spagettiIngredients)));
		pastryMap.put(Label.PARVE, Arrays.asList(pastryList.get(2), new Pastry("Israel Cake", 999, Label.PARVE, cakeIngredients)));
	}
}
