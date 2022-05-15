package decorator;

public class DressDecorator implements Dress {
	private Dress dress;
	private String type;
	
	
	public DressDecorator(Dress dress) {
		this.dress = dress;
	}

	protected void setType(String type) {
		this.type = type;
	}

	@Override
	public void create() {
		dress.create();
		System.out.println(type + " Added...");
	}
}
