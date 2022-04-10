package bootcamp.oop.player;

import java.util.Random;

public class Player {

	private static int totalPoints;
	private static int numPlayers;
	private static boolean isFirstPlayer;
	private int points;
	private int lives;
	private Random random;
	
	static {
		totalPoints = 0;
		numPlayers = 1;
		isFirstPlayer = true;
	}

	public Player() {
		points = 0;
		lives = 3;
		random = new Random();
		addPlayer();
	}

	public void eatBonus() {
		int points = getPointsWithRandom(100, 150);
		addPoints(points);
	}

	public void hitObstacle() {
		int points = getPointsWithRandom(100, 200);
		subtractPoints(points);
	}

	private int getPointsWithRandom(int option1, int option2) {
		return random.nextInt(2) == 0 ? option1 : option2;
	}

	private void addPoints(int points) {
		this.points += points;
		addTotalPoints(points);
		if (points >= 150) {
			addLives();
		}
	}

	private void subtractPoints(int points) {
		this.points -= points;
		subtractTotalPoints(points);
		if (points <= 100) {
			subtractLives();
		}
	}

	private void setLives(int lives) {
		if (lives >= 0 && lives <= 5) {
			this.lives = lives;
		}
	}

	private void addLives() {
		setLives(this.lives + 1);
	}

	private void subtractLives() {
		if (this.lives > 0) {
			setLives(this.lives - 1);
			if (this.lives == 0) {
				removePlayer();
			}
		}
	}

	private static void removePlayer() {
		if (numPlayers > 0) {
			numPlayers--;
		}
	}

	private static void addPlayer() {
		if (isFirstPlayer) // because by default numPlayers = 1
			isFirstPlayer = false;
		else if (numPlayers < 3) {
			numPlayers++;
		}
	}

	private static void addTotalPoints(int points) {
		totalPoints += points;
	}

	private static void subtractTotalPoints(int points) {
		totalPoints -= points;
	}

	@Override
	public String toString() {
		return "Player [points=" + points + ", lives=" + lives + ", totalPoints=" + totalPoints + ",  numPlayers="
				+ numPlayers + " ]";
	}

	public void print() {
		System.out.println(this.toString());
	}
}
