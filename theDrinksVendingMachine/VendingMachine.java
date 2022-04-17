package theDrinksVendingMachine;

import java.util.Scanner;

/**
 * This class represents a drinks vending machine, that supplies the costumers 8
 * different kinds of drinks.
 * 
 * @author Anna Aba
 *
 */
public class VendingMachine {
	public static int milkQtt;
	public static int waterQtt;
	public static boolean isWorking;

	static {
		milkQtt = 1000;
		waterQtt = 2000;
		isWorking = true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (isWorking) {
			showMenu();
			int opt = Integer.parseInt(sc.next());
			if (opt == 0) {
				System.out.println("Bye Bye !");
				System.exit(0);
			}
			Produceable drink = createDrink(opt);
			System.out.println("===========================");
			System.out.print("Preparing... ");
			drink.produce();
			System.out.println("Done!");
			System.out.println("===========================");
		}

		System.out.println("Sorry, the machine temporary doesnt work.");
		sc.close();
	}

	/**
	 * Based on the customer's input, the machine creates the right instance.
	 * 
	 * @param opt Customer's input - an integer.
	 * @return instance of the right drink.
	 */
	private static Produceable createDrink(int opt) {
		switch (opt) {
		case 1:
			return new HotChocolate();
		case 2:
			return new Espresso();
		case 3:
			return new Cappuccino();
		case 4:
			return new Latte();
		case 5:
			return new Cola();
		case 6:
			return new Sprite();
		case 7:
			return new OrangeJuice();
		case 8:
			return new AppleJuice();
		}

		return null;
	}

	/**
	 * Prints the menu to the console.
	 */
	public static void showMenu() {
		System.out.println("Please select a drink or enter 0 to exit:");
		System.out.println("1. Hot Chocolate\n" + "2. Hot Espresso\n" + "3. Hot Cappuccino\n" + "4. Hot Latte\n"
				+ "5. Cola\n" + "6. Sprite\n" + "7. Orange Juice\n" + "8. Apple Juice");
	}

	/**
	 * Consumes the amount of water and milk are needed for the the drink. After the
	 * consumption, it checks the amount of water and milk left. If doesn't left
	 * enough - updates the machine.
	 * 
	 * @param waterQuantity Quantity of water for the drink.
	 * @param milkQuantity  Quantity of milk for the drink.
	 */
	public static void consumeLiquid(int waterQuantity, int milkQuantity) {
		waterQtt -= waterQuantity;
		milkQtt -= milkQuantity;

		if (waterQtt < Drink.maxVolume || milkQtt < Drink.maxVolume) {
			isWorking = false;
		}
	}
}
