package decorator;

public class SportDress extends DressDecorator {
	private static final String TYPE = "Sportiness";
	
	public SportDress(Dress dress) {
		super(dress);
		setType(TYPE);
	}
}
