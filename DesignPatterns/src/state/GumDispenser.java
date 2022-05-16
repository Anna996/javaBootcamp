package state;

import java.util.Scanner;

public class GumDispenser {
	private GumDispenserState state;
	private Scanner scanner;

	public GumDispenser(GumDispenserState state) {
		changeState(state);
		scanner = new Scanner(System.in);
	}

	public void changeState(GumDispenserState state) {
		this.state = state;
		state.setGumDispenser(this);
	}

	public void start() {
		int input;

		do {
			showMenu();
			System.out.print("\nyour choise: ");
			input = scanner.nextInt();
		} while (coinInserted(input));

		scanner.close();
	}

	private void showMenu() {
		System.out.println("Welcome to the Gum Despenser Simulator");
		System.out.println("Please enter:");
		System.out.println("1 - insert coin of 5 cents");
		System.out.println("2 - insert coin of 10 cents");
		System.out.println("3 - take the gum..");
	}

	private boolean coinInserted(int coin) {
		String result = "";

		switch (coin) {
		case 1:
			result = state.inserted5Cents();
			break;
		case 2:
			result = state.inserted10Cents();
			break;
		case 3:
			result = state.collectGum();
			break;
		case 0:
			return false;
		}

		System.out.println(state.DisplayBalance());
		System.out.println(result);
		return true;
	}
}
