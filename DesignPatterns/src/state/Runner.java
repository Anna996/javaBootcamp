package state;

public class Runner {

	public static void main(String[] args) {
		GumDispenserState state = new InitialState();
		GumDispenser dispenser = new GumDispenser(state);
		dispenser.start();
	}
}
