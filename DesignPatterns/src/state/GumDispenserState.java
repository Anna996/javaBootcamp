package state;

public abstract class GumDispenserState {
	private int balance;
	protected GumDispenser dispenser;

	protected void setBalance(int balance) {
		this.balance = balance;
	}

	public void setGumDispenser(GumDispenser dispenser) {
		this.dispenser = dispenser;
	}

	public String DisplayBalance() {
		return "Balance: " + balance;
	}

	public abstract String inserted5Cents();

	public abstract String inserted10Cents();

	public abstract String collectGum();
}
