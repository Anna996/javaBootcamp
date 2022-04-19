package javabootcamp.oopexam.Toy;

import java.time.LocalDate;

import javabootcamp.oopexam.AgeGroup.AgeGroup;

public abstract class Toy {
	private long SERIAL_NUMBER;
	private String name;
	private LocalDate purchaseDate;
	private AgeGroup ageGroup;
	private static long toyCounter = 0;

	public Toy(String name, LocalDate purchaseDate, AgeGroup ageGroup) {
		setName(name);
		setPurchaseDate(purchaseDate);
		setAgeGroup(ageGroup);
		setAgeGroup(ageGroup);
		this.SERIAL_NUMBER = ++toyCounter;
	}

	public Toy(String name, LocalDate purchaseDate) {
		this(name, purchaseDate, AgeGroup.C);
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public long getSERIAL_NUMBER() {
		return SERIAL_NUMBER;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void play() {
		System.out.println("Before playing: ");
		System.out.println(this);
		System.out.println("============================");
		playing();
		System.out.println("============================");
		System.out.println("After playing: ");
		System.out.println(this);
	}

	protected abstract void playing();

	public boolean isBroken() {
		return LocalDate.now().getYear() - purchaseDate.getYear() > 1;
	}

	@Override
	public String toString() {
		return "SERIAL_NUMBER=" + SERIAL_NUMBER + ", name=" + name + ", purchaseDate=" + purchaseDate + ", ageGroup="
				+ ageGroup;
	}
}
