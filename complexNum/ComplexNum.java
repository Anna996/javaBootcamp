package bootcamp.oop.complexNum;

public class ComplexNum implements Complexable {
	private int real;
	private int imaginary;

	public ComplexNum() {
		this(0, 0);
	}

	public ComplexNum(int real, int imaginary) {
		setReal(real);
		setImaginary(imaginary);
	}

	private void setReal(int real) {
		this.real = real;
	}

	private void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}

	@Override
	public void add(ComplexNum z) {
		setReal(real + z.real);
		setImaginary(imaginary + z.imaginary);
	}

	@Override
	public void subtract(ComplexNum z) {
		setReal(real - z.real);
		setImaginary(imaginary - z.imaginary);
	}

	@Override
	public void multiply(ComplexNum z) {
		setReal(real * z.real - imaginary * z.imaginary);
		setImaginary(real * z.imaginary + imaginary * z.real);
	}

	@Override
	public void divide(ComplexNum z) {
		int denominator = z.real * z.real + z.imaginary * z.imaginary; // מכנה
		int counter = real * z.real + imaginary * z.imaginary;
		setReal(counter / denominator);
		counter = imaginary * z.real - real * z.imaginary;
		setImaginary(counter / denominator);
	}

	private static ComplexNum deepClone(ComplexNum source) {
		return new ComplexNum(source.real, source.imaginary);
	}

	public static ComplexNum add(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = deepClone(z1);
		result.add(z2);
		return result;
	}

	public static ComplexNum subtract(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = deepClone(z1);
		result.subtract(z2);
		return result;
	}

	public static ComplexNum multiply(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = deepClone(z1);
		result.multiply(z2);
		return result;
	}

	public static ComplexNum divide(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = deepClone(z1);
		result.divide(z2);
		return result;
	}

	@Override
	public ComplexNum conjugate() {
		return new ComplexNum(real, -imaginary);
	}

	@Override
	public double mag() {
		double result = real * real + imaginary * imaginary;
		return Math.sqrt(result);
	}

	// (a + bi) * (a - bi) == cc*
	@Override
	public ComplexNum square() {
		ComplexNum result = deepClone(this);
		ComplexNum conjugate = this.conjugate();
		result.multiply(conjugate);
		return result;
	}

	@Override
	public ComplexNum pow(ComplexNum z, int power) {
		ComplexNum result = deepClone(z);
		for (int i = 1; i < power; i++) {
			result.multiply(result);
		}
		return result;
	}

	// "-4+7i" "4+7i"
	public static ComplexNum parseComplex(String s) {
		int a, b, idx = 0;
		char c = s.charAt(idx);

		if (c == '+' || c == '-') {
			idx = 1;
		} else if (!Character.isDigit(c)) {
			System.out.println("Invalid input");
			return null;
		}

		a = s.charAt(idx) - '0';
		if (c == '-') {
			a *= -1;
		}
		idx = Character.isDigit(s.charAt(1)) ? 3 : 2;
		b = s.charAt(idx) - '0';
		if (s.charAt(idx - 1) == '-') {
			b *= -1;
		}

		return new ComplexNum(a, b);
	}

	@Override
	public ComplexNum inverse() {
		int denominator = real * real + imaginary * imaginary;
		return new ComplexNum(real / denominator, -imaginary / denominator);
	}

	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

		// typecast obj to ComplexNum so that we can compare data members
		ComplexNum other = (ComplexNum) obj;

		// Compare the data members and return accordingly
		return Integer.compare(real, other.real) == 0 && Integer.compare(imaginary, other.imaginary) == 0;
	}

	@Override
	public String toString() {
		char pattern = '+';
		int positiveB = imaginary;
		if (imaginary < 0) {
			pattern = '-';
			positiveB *= -1;
		}
		return String.format("(%d %c %di)", real, pattern, positiveB);
	}
}
