package stream_api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import stream_api.GameCharacter.Continent;

public class Runner {

	public static void main(String[] args) {
		List<GameCharacter> characters = Arrays.asList(
				new GameCharacter("Arthas Menethil", "Lich King", "Icecrown", 80, 1500, Continent.Northrend),
				new GameCharacter("Thrall", "Warchief", "Orgrimmar", 90, 1200, Continent.Kalimdor),
				new GameCharacter("Jaina Proudmoore", "Lord Admiral", "Kul Tiras", 120, 1000, Continent.Eastern_Kingdoms),
				new GameCharacter("Tyrande Whisperwind", "Priestess of Elune", "Teldrassil", 120, 1100, Continent.Kalimdor),
				new GameCharacter("Sylvanas Windrunner", "Dark Ranger", "Undercity", 120, 1100, Continent.Eastern_Kingdoms));
		
		// Question 1
		List<String> namesOfKalimdorCharacters = characters
				.stream()
				.filter(x -> x.getContinent() == Continent.Kalimdor)
				.map(c -> c.getName())
				.collect(Collectors.toList());
		System.out.println("The names of kalimdor characters:");
		namesOfKalimdorCharacters.forEach(System.out::println);
		
		
		// Question 2
		System.out.println("\nThe characters sorted by their hit points:");
		characters
		.stream()
		.sorted( (c1,c2) -> {
			double answer = c2.getHitPoints() - c1.getHitPoints();
			return answer == 0 ? 0 : answer > 0 ? 1 : -1;
		})
		.forEach(System.out::println);
		
		// Question 3
		List<GameCharacter> atLevel120 = characters
				.stream()
				.filter(c -> c.getLevel() == 120)
				.collect(Collectors.toList());
		
		double average = atLevel120
				.stream()
				.map(c -> c.getHitPoints())
				.reduce(0.0,(prev,curr)->prev+curr) / atLevel120.size();
		System.out.printf("\naverage hit points of characters in level 120: %.2f \n" , average);
		
		// Question 4
		List<String> names = Arrays.asList("Yosi","Shalom","Dor","Avi","Dianna");
		List<GameCharacter> newCharacters = names
				.stream()
				.map(name -> new GameCharacter(name, name + " power", "Israela", 1, 0, Continent.Northrend))
				.collect(Collectors.toList());
		
		System.out.println("\nThe new characters:");
		newCharacters.stream().forEach(System.out::println);
	}
}
