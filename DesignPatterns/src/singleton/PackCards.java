package singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class PackCards {
	private static PackCards instance = null;
	private List<Integer> cards;
	public final int AMOUNT = 60;

	private PackCards() {
		initListOfCards();
	}

	public static PackCards getInstance() {
		if (instance == null) {
			instance = new PackCards();
		}

		return instance;
	}

	public void initListOfCards() {
		cards = new ArrayList<>();

		for (int i = 1; i <= AMOUNT; i++) {
			cards.add(i);
		}
	}

	// numberCard is between 1 and AMOUNT
	public int getCard(int numberCard) {
		return cards.get(numberCard);
	}

	public void removeCard(int numberCard) {
		cards.remove(numberCard);
	}

	public boolean isEmpty() {
		return cards.isEmpty();
	}

	public int takeRandomCard() {
		Random random = new Random();
		int index = random.nextInt(cards.size());
		int currCal = cards.remove(index);

		return currCal;
	}
}
