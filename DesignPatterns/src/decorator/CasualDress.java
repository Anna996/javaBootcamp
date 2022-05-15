package decorator;

public class CasualDress extends DressDecorator {
	private static final String TYPE = "Casuality";

	public CasualDress(Dress dress) {
		super(dress);
		setType(TYPE);
	}
}
