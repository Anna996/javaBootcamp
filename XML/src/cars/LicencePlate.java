package cars;

public class LicencePlate {
	private final long PLATE_NUMBER;
	private String color;

	private static long counter = 1000;

	public LicencePlate(String color) {
		PLATE_NUMBER = counter++;
		this.color = color;
	}
	
	public LicencePlate(long PLATE_NUMBER,String color) {
		this.PLATE_NUMBER = PLATE_NUMBER;
		this.color = color;
	}

	public long getPLATE_NUMBER() {
		return PLATE_NUMBER;
	}

	public String getColor() {
		return color;
	}

	public static long getCounter() {
		return counter;
	}

	@Override
	public String toString() {
		return "LicencePlate [PLATE_NUMBER=" + PLATE_NUMBER + ", color=" + color + "]";
	}
}
