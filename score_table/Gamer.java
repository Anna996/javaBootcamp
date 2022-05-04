package score_table;

import java.util.Objects;

public class Gamer implements Comparable<Gamer> {
	private int score;
	private String name;
	private String country;
	private float rank;

	public Gamer(String name, String country) {
		setName(name);
		setCountry(country);
		setScore(0);
		setRank(0);
	}

	public void setScore(int score) {
		this.score = score;
		setRank(score / 10.2f);
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setCountry(String country) {
		this.country = country;
	}

	public void setRank(float rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public float getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return "[score=" + score + ", name=" + name + ", country=" + country + String.format(", rank= %.2f", rank) + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gamer other = (Gamer) obj;
		return score == other.score;
	}

	@Override
	public int compareTo(Gamer o) {
		return o.score - this.score;
	}
}
