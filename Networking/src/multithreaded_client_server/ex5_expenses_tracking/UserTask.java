package multithreaded_client_server.ex5_expenses_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserTask implements Runnable {

	private Socket socket;
	private Map<Integer, List<Expense>> db;

	public UserTask(Socket socket, Map<Integer, List<Expense>> db) {
		this.socket = socket;
		this.db = db;
	}

	@Override
	public void run() {
		try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);) {

			String data = bufferReader.readLine();
			String[] values = data.split(";");

			int id = Integer.valueOf(values[0]);
			System.out.println("accepted User " + id);

			synchronized (db) {
				if (!db.containsKey(id)) {
					db.put(id, new ArrayList<>());
				}

				db.get(id)
						.add(new Expense(LocalDateTime.now(), Category.valueOf(values[1]), Double.valueOf(values[2])));
			}

			writer.println("true");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
