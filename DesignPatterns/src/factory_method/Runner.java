package factory_method;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter 1 - dark , 2 - bright: ");
		int input = scanner.nextInt();
		ThemeFactory theme = input == 1 ? new DarkThemeFactory() : new BrightThemeFactory();
		
		theme.runLogic();
	}

}
