package command;

import java.time.LocalTime;

public class TurnOnCommand implements Command {
	private String info;
	private int minutes;

	public TurnOnCommand(int minutes) {
		setMinutes(minutes);
	}

	private void setMinutes(int minutes) {
		this.minutes = minutes <= 30 ? minutes : 90;
	}

	@Override
	public void execute() {
		info = String.format("Heater turned for %d minutes on %s", minutes, LocalTime.now());
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "TurnOnCommand --> " + info;
	}
}
