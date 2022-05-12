package adapter;

public class Sparrow implements Bird {

	@Override
	public void fly() {
		System.out.println("Sparrow: Flying...");
	}

	@Override
	public void makeSound() {
		System.out.println("Sparrow: Chirp Chirp...");
	}
}
