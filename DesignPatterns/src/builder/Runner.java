package builder;

public class Runner {

	public static void main(String[] args) {
		Director director = new Director();
		
		//  Hawaiian Pizza
		Builder pizzaBuilder = new PastryBuilder();
		director.createHawaiianPizza(pizzaBuilder);
		Pastry hawaiianPizza = pizzaBuilder.getResult();
		System.out.println(hawaiianPizza.created());
		
		//  Dominican Puff-Pastry
		Builder puffPastryBuilder = new PastryBuilder();
		director.createDominicanPuffPastry(puffPastryBuilder);
		Pastry dominicanPuffPastry = puffPastryBuilder.getResult();
		System.out.println(dominicanPuffPastry.created());
		
	    //  Hawaiian Pizza Recipe
		Builder pizzaRecipeBuilder = new RecipeBuilder();
		director.createHawaiianPizza(pizzaRecipeBuilder);
		Pastry hawaiianPizzaRecipe = pizzaRecipeBuilder.getResult();
		System.out.println(hawaiianPizzaRecipe);
		
		//  Dominican Puff-Pastry Recipe
		Builder puffPastryRecipeBuilder = new RecipeBuilder();
		director.createDominicanPuffPastry(puffPastryRecipeBuilder);
		Pastry dominicanPuffPastryRecipe = puffPastryRecipeBuilder.getResult();
		System.out.println(dominicanPuffPastryRecipe);
	}
}
