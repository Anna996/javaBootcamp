package singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGame {
	private PackCards packCards;
	List<Player> players;
	public final int NUM_OF_PLAYERS = 4;

	public void start() {
		packCards = PackCards.getInstance();
		initPlayers();
		play();
		showResult();
	}

	private void initPlayers() {
		players = new ArrayList<>(NUM_OF_PLAYERS);

		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			players.add(new Player("Player " + (i + 1)));
		}
	}

	private void play() {
		int i = 1;

		while (!packCards.isEmpty()) {
			System.out.println("Buttle " + i++);
			playButtle();
			printWinnerOfButtle();
		}
	}

	private void playButtle() {
		Player current;

		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			current = players.get(i);
			current.takeRandomCard();
			System.out.println(current.info());
		}
	}

	private void printWinnerOfButtle() {
		Player winner = Collections.max(players, (player1, player2) -> player1.getLastCard() - player2.getLastCard());
		System.out.println("Result: " + winner.getName() + " won the buttle\n");
		winner.wonButtle();
	}

	private void showResult() {
		Player winner = Collections.max(players, (player1, player2) -> player1.getPoints() - player2.getPoints());
		System.out.println("Game winner: " + winner.getName() + " with " + winner.getPoints() + " points !!!");
	}
}
