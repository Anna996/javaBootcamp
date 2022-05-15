package decorator;

import java.util.Arrays;
import java.util.List;

import decorator.BasicDress.Size;

public class Runner {

	public static void main(String[] args) {
		Dress basic = new BasicDress("Pink", Size.L);
		
		List<Dress> dresses = Arrays.asList(
				basic,
				new FancyDress(basic),
				new CasualDress(basic),
				new SportDress(new FancyDress(basic)),
				new CasualDress(new FancyDress(basic)),
				new FancyDress(new CasualDress(new SportDress(basic)))
				);
		
		dresses.forEach(dress -> {
			System.out.println("====================");
			dress.create();
		});
	}
}
