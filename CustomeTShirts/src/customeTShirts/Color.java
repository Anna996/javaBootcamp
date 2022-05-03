package customeTShirts;

public class Color {
	protected short red;
	protected short green;
	protected short blue;
	protected static final short MIN = 0;
	protected static final short MAX = 255;
	protected static final String RED = "RED";
	protected static final String GREEN = "GREEN";
	protected static final String BLUE = "BLUE";

	public Color() {
		this(MIN, MIN, MIN);
	}

	public Color(int red, int green, int blue) {
		this((short) red, (short) green, (short) blue);
	}

	public Color(short red, short green, short blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}

	protected void setRed(short red) {
		this.red = isValidRange(red) ? red : MIN;
	}

	protected void setGreen(short green) {
		this.green = isValidRange(green) ? green : MIN;
	}

	protected void setBlue(short blue) {
		this.blue = isValidRange(blue) ? blue : MIN;
	}

	@Override
	public String toString() {
		return "Color [red=" + red + ", green=" + green + ", blue=" + blue + "]";
	}

	private boolean isValidRange(short input) {
		return Utils.isInRange(input, MIN, MAX);
	}

	public String getDominant() {
		String name = RED;

		if (green > red) {
			name = green > blue ? GREEN : BLUE;
		}

		return name;
	}

	public float[] normalized() {
		return new float[] { red / MAX, green / MAX, blue / MAX };
	}
}
