package adapter;

public class Runner {

	public static void main(String[] args) {
		Bird sparrow = new Sparrow();
		sparrow.fly();
		sparrow.makeSound();
		
		ToyDuck plasticToyDuck = new PlasticToyDuck();
		plasticToyDuck.squeak();
		
		ToyDuck sparrowToyDuck = new BirdToToyDuckAdapter(sparrow);
		sparrowToyDuck.squeak();
	}
}
