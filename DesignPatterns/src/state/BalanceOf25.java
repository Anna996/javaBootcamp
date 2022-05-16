package state;

public class BalanceOf25 extends GumDispenserState {
	private String takeTheGum;

	public BalanceOf25() {
		super();
		super.setBalance(25);
		takeTheGum = "Please take the gum, before inserting more coins\n";
	}

	@Override
	public String inserted5Cents() {
		return takeTheGum;
	}

	@Override
	public String inserted10Cents() {
		return takeTheGum;
	}

	@Override
	public String collectGum() {
		dispenser.changeState(new InitialState());
		return "Goodbye! :)";
	}
}