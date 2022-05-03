package customeTShirts;

import customeTShirts.Tshirt.Size;

public class Runner {

	public static void main(String[] args) {
		Color color = new Color(142, 172, 152);
		Design design = new Design(20, 10.2, "Hola 2022", color, 20);
		Tshirt[] shirts = new Tshirt[] { new Tshirt(), new Tshirt(Size.L, null, 0.8, 50),
				new Tshirt(Size.XL, design, 1, 5) };

		for (Tshirt shirt : shirts) {
			System.out.println("================");
			System.out.println(shirt);
			System.out.printf("Final price: %.2f\n", shirt.calculateFinalPrice());
			System.out.println("Is Exapensive?: " + shirt.isExpensive());
			System.out.println(" ");
		}
	}
}
