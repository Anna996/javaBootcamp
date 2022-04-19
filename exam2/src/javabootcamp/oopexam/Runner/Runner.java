package javabootcamp.oopexam.Runner;

import java.time.LocalDate;
import java.util.Random;

import javabootcamp.oopexam.AgeGroup.AgeGroup;
import javabootcamp.oopexam.Doll.Doll;
import javabootcamp.oopexam.Doll.Doll.Softteness;
import javabootcamp.oopexam.Electric.Electric;
import javabootcamp.oopexam.Toy.Toy;

public class Runner {

	public static void main(String[] args) {

		Doll doll1 = new Doll("barbi", LocalDate.of(2022, 02, 15), AgeGroup.A, Softteness.HARD);
		Doll doll2 = new Doll("Bear", LocalDate.of(2022, 03, 25), AgeGroup.B, Softteness.SOFT);

		Electric el1 = new Electric("el1", LocalDate.of(2022, 02, 10), AgeGroup.C, 3, 2);
		Electric el2 = new Electric("shalom2", LocalDate.of(2022, 02, 22), AgeGroup.C, 5, 3);

		Toy[] toys = { doll1, doll2, el1, el2 };

		int count = 1;
		Random random = new Random();
		int idx;

		while (count < 6) {
			idx = random.nextInt(4);
			toys[idx].play();
			System.out.println("\n \n \n");
			count++;
		}
	}
}
