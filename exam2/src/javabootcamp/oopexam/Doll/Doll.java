package javabootcamp.oopexam.Doll;

import java.time.LocalDate;

import javabootcamp.oopexam.AgeGroup.AgeGroup;
import javabootcamp.oopexam.Toy.Toy;

public class Doll extends Toy {
	private Softteness softteness;
	private int levelOfDirty;

	public Doll(String name, LocalDate purchaseDate, AgeGroup ageGroup, Softteness softteness) {
		super(name, purchaseDate);
		setAgeGroup(ageGroup);
		setSoftteness(softteness);
		setLevelOfDirty(1);
	}

	private void setSoftteness(Softteness softteness) {
		this.softteness = softteness;
	}

	private void setLevelOfDirty(int levelOfDirty) {
		this.levelOfDirty = levelOfDirty >= 1 && levelOfDirty <= 10 ? levelOfDirty : 10;
	}

	@Override
	public void setAgeGroup(AgeGroup ageGroup) {
		if (ageGroup == AgeGroup.A || ageGroup == AgeGroup.B) {
			super.setAgeGroup(ageGroup);
		} else {
			super.setAgeGroup(AgeGroup.A);
		}
	}

	@Override
	protected void playing() {
		System.out.println("Playing with a Doll...");
		setLevelOfDirty(levelOfDirty + 1);
	}

	@Override
	public String toString() {
		return "[" + super.toString() + ", softteness=" + softteness + ", levelOfDirty=" + levelOfDirty + "]";
	}

	public static enum Softteness {
		SOFT, HARD
	}
}
