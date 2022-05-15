package decorator;

public class FancyDress extends DressDecorator {
	private static final String TYPE = "Fanciness";

	public FancyDress(Dress dress) {
		super(dress);
		setType(TYPE);
	}
}
