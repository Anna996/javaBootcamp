package singleton;

public class Player {
	private PackCards packCards;
	private int points;
	private int lastCard;
	private String name;

	public Player(String name) {
		packCards = PackCards.getInstance();
		setPoints(0);
		this.name = name;
	}

	private void setPoints(int points) {
		this.points = points;
	}

	private void setLastCard(int lastCard) {
		this.lastCard = lastCard;
	}

	public int getLastCard() {
		return lastCard;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public void takeRandomCard() {
		setLastCard(packCards.takeRandomCard());
	}

	public void wonButtle() {
		setPoints(points + 1);
	}

	public String info() {
		return String.format("name: %s , card: %d", name, lastCard);
	}
}