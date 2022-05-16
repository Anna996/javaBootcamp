package state;

public class InitialState extends GumDispenserState {

	public InitialState() {
		super();
		super.setBalance(0);
	}

	@Override
	public String inserted5Cents() {
		dispenser.changeState(new BalanceOf5());
		return "";
	}

	@Override
	public String inserted10Cents() {
		dispenser.changeState(new BalanceOf10());
		return "";
	}

	@Override
	public String collectGum() {
		return "You have to insert 25 cents";
	}
}
