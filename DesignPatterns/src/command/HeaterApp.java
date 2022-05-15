package command;

import java.util.LinkedList;
import java.util.List;

public class HeaterApp {
	private List<Command> history;
	private final int LAST_COMMANDS = 5;

	public HeaterApp() {
		history = new LinkedList<>();
	}

	public void TurnOn(int minutes) {
		executeCommand(new TurnOnCommand(minutes));
	}

	public void TurnOff() {
		executeCommand(new TurnOffCommand());
	}

	public void showHistory() {
		int idx = history.size() < LAST_COMMANDS ? 0 : history.size() - LAST_COMMANDS;
		history.subList(idx, history.size()).forEach(System.out::println);	
	}

	private void executeCommand(Command command) {
		command.execute();
		history.add(command);
	}
}
