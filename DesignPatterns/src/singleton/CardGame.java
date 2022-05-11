package singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CardGame {
	private PackCards packCards;
	private List<Integer> remainCards;
	private Map<Integer, Integer> players; // key: id, value: points;
	private Random random;
	public final int NUM_OF_PLAYERS = 4;

	public void start() {
		packCards = PackCards.getInstance();
		random = new Random();
		initRemainCards();
		initPlayers();
		play();
		showResult();
	}

	private void initRemainCards() {
		remainCards = new ArrayList<>();
		for (int i = 1; i <= packCards.AMOUNT; i++) {
			remainCards.add(i);
		}
	}

	private void initPlayers() {
		players = new HashMap<>();
		for (int i = 1; i <= NUM_OF_PLAYERS; i++) {
			players.put(i, 0);
		}
	}

	private void play() {
		int i = 1;
		
		while (remainCards.size() > 0) {
			playButtle(i++);
		}
	}

	private void playButtle(int numButtle) {
		int max = -1, winning = 0;
		int index , currVal;

		System.out.println("Buttle " + numButtle);
		for (int i = 1; i <= NUM_OF_PLAYERS; i++) {
			index = random.nextInt(remainCards.size());
			currVal = remainCards.get(index);
			remainCards.remove(index);
			System.out.println("Player " + i + " - " + packCards.getCard(currVal));
			if (currVal > max) {
				max = currVal;
				winning = i;
			}
		}
		System.out.println("Result: Player " + winning + " won the buttle\n");
		players.put(winning, players.get(winning) + 1);
	}

	private void showResult() {
		int max = -1, winning = 0, points = 0;

		for (int i = 1; i <= NUM_OF_PLAYERS; i++) {
			points = players.get(i);
			System.out.println("player " + i + "  -  points: " + points);
			if(points > max) {
				max = points;
				winning = i;
			}
		}
		
		System.out.println("Game winner: player number " + winning + " with "+ max + " points !!!");
	}
}
