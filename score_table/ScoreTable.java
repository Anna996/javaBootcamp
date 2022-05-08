package score_table;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ScoreTable {
	private List<Gamer> gamers;
	private final int TOP = 10;

	public ScoreTable() {
		gamers = new LinkedList<>();
	}

	public void addGamer(Gamer gamer) {
		if (gamer == null) {
			System.out.println("Invalid gamer");
			return;
		}
		gamers.add(gamer);
	}

	public void update() {
		System.out.println("TOP 10 !");
		System.out.println("========");

		Collections.sort(gamers);

		Iterator<Gamer> iterator = gamers.iterator();
		for (int i = 1; i <= TOP && iterator.hasNext(); i++) {
			System.out.println(i + ". " + iterator.next());
		}
	}

	public void listByUserName() {
		Comparator<Gamer> byUserName = new Comparator<Gamer>() {

			@Override
			public int compare(Gamer o1, Gamer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};

		List<Gamer> copy = new LinkedList<>(gamers);
		System.out.println("List sorted by the user name");
		System.out.println("============================");
		Collections.sort(copy, byUserName);
		printValues(copy);
	}

	private void printValues(List<Gamer> queue) {
		Iterator<Gamer> iterator = queue.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void listByUserCountry() {
		Comparator<Gamer> byUserCountry = new Comparator<Gamer>() {

			@Override
			public int compare(Gamer o1, Gamer o2) {
				return o1.getCountry().compareTo(o2.getCountry());
			}
		};

		List<Gamer> copy = new LinkedList<>(gamers);
		System.out.println("List sorted by the user country");
		System.out.println("===============================");
		Collections.sort(copy, byUserCountry);
		printValues(copy);
	}

	public void listByUserRank() {
		Comparator<Gamer> byUserRank = new Comparator<Gamer>() {

			@Override
			public int compare(Gamer o1, Gamer o2) {
				return Float.compare(o2.getRank(), o1.getRank());
			}
		};

		List<Gamer> copy = new LinkedList<>(gamers);
		Collections.sort(copy, byUserRank);
		System.out.println("List sorted by the user rank");
		System.out.println("============================");
		printValues(copy);
	}
}