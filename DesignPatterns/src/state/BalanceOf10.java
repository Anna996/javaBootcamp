package state;

public class BalanceOf10 extends GumDispenserState {

	public BalanceOf10() {
		super();
		super.setBalance(10);
	}

	@Override
	public String inserted5Cents() {
		dispenser.changeState(new BalanceOf15());
		return "";
	}

	@Override
	public String inserted10Cents() {
		dispenser.changeState(new BalanceOf20());
		return "";
	}

	@Override
	public String collectGum() {
		return "You have to insert 15 cents";
	}
}
