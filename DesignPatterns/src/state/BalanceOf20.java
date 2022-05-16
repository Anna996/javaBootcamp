package state;

public class BalanceOf20 extends GumDispenserState {

	public BalanceOf20() {
		super();
		super.setBalance(20);
	}

	@Override
	public String inserted5Cents() {
		dispenser.changeState(new BalanceOf25());
		return "";
	}

	@Override
	public String inserted10Cents() {
		return "Please insert coin of 5 cent\n";
	}

	@Override
	public String collectGum() {
		return "You have to insert 5 cents";
	}
}
