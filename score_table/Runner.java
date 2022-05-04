package score_table;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		ScoreTable scoreTable = new ScoreTable();

		List<Gamer> gamers = new ArrayList<>();
		gamers.add(new Gamer("Alon", "Israel"));
		gamers.add(new Gamer("Shalom", "Italy"));
		gamers.add(new Gamer("Or", "Spain"));
		gamers.add(new Gamer("Alona", "Israel"));
		gamers.add(new Gamer("Ran", "Israel"));
		gamers.add(new Gamer("Dan", "Italy"));
		gamers.add(new Gamer("Orit", "Spain"));
		gamers.add(new Gamer("Mai", "Dubai"));
		gamers.add(new Gamer("Ali", "USA"));
		gamers.add(new Gamer("Inna", "Israel"));
		gamers.add(new Gamer("Rahel", "Spain"));
		gamers.add(new Gamer("Adam", "USA"));

		Iterator<Gamer> iter = gamers.iterator();
		while (iter.hasNext()) {
			scoreTable.addGamer(iter.next());
		}

		int[] scores = new int[] { 150, 250, 30, 500, 234, 80, 144, 345, 522, 192, 17, 10 };
		for (int i = 0; i < gamers.size(); i++) {
			gamers.get(i).setScore(scores[i]);
		}

		scoreTable.update();
		
		System.out.println("");
		scoreTable.listByUserName();
		System.out.println("");
		scoreTable.listByUserCountry();
		System.out.println("");
		scoreTable.listByUserRank();
	}
}