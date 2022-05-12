package adapter;

public class BirdToToyDuckAdapter implements ToyDuck {

	private Bird bird;
	
	public BirdToToyDuckAdapter(Bird bird) {
		this.bird = bird;
	}

	@Override
	public void squeak() {
		bird.makeSound();
	}
}
