package javabootcamp.oopexam.Electric;

import java.time.LocalDate;

import javabootcamp.oopexam.AgeGroup.AgeGroup;
import javabootcamp.oopexam.Toy.Toy;

public class Electric extends Toy {
	private int numOfButteries;
	private int levelOfSound;

	public Electric(String name, LocalDate purchaseDate, AgeGroup ageGroup, int numOfButteries, int levelOfSound) {
		super(name, purchaseDate, ageGroup);
		setNumOfButteries(numOfButteries);
		setLevelOfSound(levelOfSound);
	}

	private void setNumOfButteries(int numOfButteries) {
		this.numOfButteries = numOfButteries;
	}

	private void setLevelOfSound(int levelOfSound) {
		this.levelOfSound = levelOfSound >= 0 && levelOfSound <= 3 ? levelOfSound : 3;
	}

	@Override
	protected void playing() {
		System.out.println("Playing with an electric toy...");
		setLevelOfSound(levelOfSound - 1);
	}

	@Override
	public String toString() {
		return "[" + super.toString() + ", numOfButteries=" + numOfButteries + ", levelOfSound=" + levelOfSound + "]";
	}
}
