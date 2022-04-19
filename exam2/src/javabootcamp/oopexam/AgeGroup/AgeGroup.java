package javabootcamp.oopexam.AgeGroup;

public enum AgeGroup {
	A(0, 1), B(2, 4), C(5, 10);

	int min, max;

	AgeGroup(int min, int max) {
		this.min = min;
		this.max = max;
	}
}
