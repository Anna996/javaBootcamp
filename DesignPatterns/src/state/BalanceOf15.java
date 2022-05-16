package state;

public class BalanceOf15 extends GumDispenserState {

	public BalanceOf15() {
		super();
		super.setBalance(15);
	}

	@Override
	public String inserted5Cents() {
		dispenser.changeState(new BalanceOf20());
		return "";
	}

	@Override
	public String inserted10Cents() {
		dispenser.changeState(new BalanceOf25());
		return "";
	}

	@Override
	public String collectGum() {
		return "You have to insert 10 cents";
	}
}
