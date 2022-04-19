package javabootcamp.oopexam.ToyForKid;

import java.time.LocalDate;

import javabootcamp.oopexam.AgeGroup.AgeGroup;
import javabootcamp.oopexam.Kid.Kid;
import javabootcamp.oopexam.Toy.Toy;

public class ToyForKid {
	private Kid kid;
	private Toy[] toys;

	public ToyForKid(Kid kid) {
		setKid(kid);
		toys = new Toy[0];
	}

	private void setKid(Kid kid) {
		this.kid = kid;
	}

	public boolean canPlayWith(Toy toy) {
		AgeGroup ageGroupOfKid = checkAgeGroup(kid.getBirthdate());

		if (!toy.isBroken() && toy.getAgeGroup() == ageGroupOfKid) {
			addToy(toy);
			return true;
		}
		return false;
	}

	private AgeGroup checkAgeGroup(LocalDate birthdate) {
		switch (birthdate.getYear()) {
		case 0:
		case 1:
			return AgeGroup.A;
		case 2:
		case 3:
		case 4:
			return AgeGroup.B;
		default:
			return AgeGroup.C;
		}
	}

	private void addToy(Toy toy) {
		Toy[] updated = new Toy[this.toys.length + 1];
		int i = 0;

		for (Toy val : toys) {
			updated[i++] = val;
		}
		updated[i] = toy;
		this.toys = updated;
	}
}
