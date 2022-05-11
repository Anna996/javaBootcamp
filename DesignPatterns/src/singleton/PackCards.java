package singleton;

import java.util.HashMap;
import java.util.Map;

public final class PackCards {
	private static PackCards instance = null;
	private Map<Integer, String> cards;
	public final int AMOUNT = 60;
	
	private PackCards() {
		initListOfCards();
	}
	
	public static PackCards getInstance() {
		if(instance == null) {
			instance = new PackCards();
		}
		
		return instance;
	}

	private void initListOfCards() {
		 cards = new HashMap<>();
		 
		 for (int i = 1; i <= AMOUNT; i++) {
			cards.put(i, "Card Number " + i);
		}
	}
	
	// numberCard is between 1 and AMOUNT
	public String getCard(int numberCard) {
		return cards.get(numberCard);
	}
}
