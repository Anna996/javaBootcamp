package javabootcamp.oopexam.Kid;

import java.time.LocalDate;

import javabootcamp.oopexam.ToyForKid.ToyForKid;

public class Kid {
	private String name;
	private LocalDate birthdate;
	private ToyForKid[] toys;

	public Kid(String name, LocalDate birthdate, ToyForKid[] toys) {
		setName(name);
		setBirthdate(birthdate);
		setToys(toys);
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	private void setToys(ToyForKid[] toys) {
		this.toys = toys;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}
}
