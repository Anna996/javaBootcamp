package decorator;

public class BasicDress implements Dress {
	private String color;
	private Size size;

	public BasicDress(String color, Size size) {
		this.color = color;
		this.size = size;
	}

	@Override
	public void create() {
		System.out.print("Basic Dress features: ");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "color=" + color + ", size=" + size;
	}

	public enum Size {
		XS, S, M, L, XL
	}

}
