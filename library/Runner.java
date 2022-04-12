package bootcamp.oop.library;

import java.util.Random;

public class Runner {

	public static void main(String[] args) {

		Author aviLevi = new Author("Avi levi", 'm');
		Author karinGoren = new Author("karin goren", 'f');
		Author haimShalom = new Author("haim shalom", 'm');

		Book readable = new ReadableBook("life 2020", eType.NOVEL, 5, aviLevi);
		Book readable2 = new ReadableBook("America", eType.NOVEL, 5, aviLevi);

		Book boorow = new BorrowableBook("Cakes", eType.COOKING, 3, karinGoren, 60);
		Book boorow2 = new BorrowableBook("XYZ", eType.DICTIONARY, 3, haimShalom, 90);

		Book purchase = new PurchasableBook("ABC", eType.DICTIONARY, 10, haimShalom, 120, 250);
		Book purchase2 = new PurchasableBook("Pudding", eType.COOKING, 10, karinGoren, 60, 120);

		Book[] books = { readable, readable2, boorow, boorow2, purchase, purchase2 };

		int counter = 8;
		Random random = new Random();
		while (counter > 0) {
			int idx = random.nextInt(books.length);
			books[idx].approach();
			counter--;
			System.out.println("");
		}
	}
}
