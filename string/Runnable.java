package bootcamp.oop.string;

import java.util.Scanner;

public class Runnable {

	private static Scanner scanner = new Scanner(System.in);

	public static void printMenu() {
		String menuText = "Please enter the number of your selection from the following options:\r\n";
		menuText += "1. Enter 2 sentences and I値l tell you if one is the other written backwards.\r\n";
		menuText += "2. Enter a word and I値l tell you if it is a palindrome.\r\n";
		menuText += "3. Enter a sentence and a word and I値l remove that word from anywhere in the sentence for you.\r\n";
		menuText += "4. Enter a sentence and I値l capitalize the beginning of each word in it.\r\n";
		menuText += "5. Enter a sentence and 2 words and I値l replace that first word with the second from everywhere in the sentence for you.\r\n";
		menuText += "6. Enter a sentence and a letter and I値l print all the words that start with that letter.\r\n";
		menuText += "7. Exit\r\n";
		System.out.println(menuText);
	}

	public static String getUserInput(String message) {
		System.out.print(message);
		return scanner.nextLine();
	}

	public static void printResult(String message) {
		System.out.println(message);
	}

	// question 1
	public static void handleInput1() {
		String str1 = getUserInput("Enter sentence 1: ");
		String str2 = getUserInput("Enter sentence 2: ");
		printResult("Answer: " + isReversed(str1, str2));
	}

	public static boolean isReversed(String str1, String str2) {
		String reveredStr2 = reverseStr(str2);
		return str1.equals(reveredStr2);
	}

	public static String reverseStr(String sentance) {
		int n = sentance.length();
		char[] reversed = new char[n];
		for (int i = 0; i < n; i++) {
			reversed[n - 1 - i] = sentance.charAt(i);
		}
		return String.valueOf(reversed);
	}

	// question 2
	public static void handleInput2() {
		String word = getUserInput("Enter a word: ");
		printResult("Answer: " + isPalindrom(word));
	}

	public static boolean isPalindrom(String str) {
		String revered = reverseStr(str);
		return str.equals(revered);
	}

	// question 3
	public static void handleInput3() {
		String str = getUserInput("Enter sentence: ");
		String word = getUserInput("Enter a word: ");
		printResult("New sentence: " + removeWord(str, word));
	}

	public static String removeWord(String str, String word) {
		return str.replace(word, "");
	}

	public static void main(String[] args) {
		int input;

		do {
			printMenu();
			input = Integer.parseInt(scanner.nextLine());

			switch (input) {
			case 1:
				handleInput1();
				break;
			case 2:
				handleInput2();
				break;
			case 3:
				handleInput3();
				break;
			case 7:
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Invalid input, try again.");
			}

		} while (input != 7);
		scanner.close();
	}
}
