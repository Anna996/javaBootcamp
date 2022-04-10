package bootcamp.oop.player;

import java.util.Random;

public class Runner {

	public static void main(String[] args) {
		Player player1 = new Player();
		Player player2 = new Player();

		player1.print();
		player2.print();

		Random random = new Random();
		Player current;
		for (int i = 1; i <= 3; i++) {
			current = random.nextInt(2) == 0 ? player1 : player2;
			current.eatBonus();
			current.hitObstacle();
		}
		
		player1.print();
		player2.print();
	}
}
