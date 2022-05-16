package state;

public class BalanceOf5 extends GumDispenserState {

	public BalanceOf5() {
		super();
		super.setBalance(5);
	}

	@Override
	public String inserted5Cents() {
		dispenser.changeState(new BalanceOf10());
		return "";
	}

	@Override
	public String inserted10Cents() {
		dispenser.changeState(new BalanceOf15());
		return "";
	}

	@Override
	public String collectGum() {
		return "You have to insert 20 cents";
	}
}
