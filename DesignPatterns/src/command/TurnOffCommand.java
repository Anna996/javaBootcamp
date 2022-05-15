package command;

import java.time.LocalTime;

public class TurnOffCommand implements Command {
	private String info;

	@Override
	public void execute() {
		info = "Heater turned off on " + LocalTime.now();
		System.out.println(this);
	}


	@Override
	public String toString() {
		return "TurnOffCommand --> " + info;
	}
}
