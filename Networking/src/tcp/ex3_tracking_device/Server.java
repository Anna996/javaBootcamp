package tcp.ex3_tracking_device;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * This is an implementation of a TCP server
 */
public class Server {
	private final int PORT;
	private Map<Long, List<Location>> db;

	private ServerSocket serverSocket = null;
	private BufferedReader bufferReader = null;
	private PrintWriter writer = null;

	public Server(int port) {
		PORT = port;
		db = new HashMap<>();
	}

	public void start() throws IOException {
		try {
			// start server
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started on port " + PORT);

			while (true) {
				// 3 way handshake
				Socket clientSocket = serverSocket.accept();
				System.out.println(
						"client is connected " + clientSocket.getInetAddress() + " port " + clientSocket.getPort());

				// create reader
				bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				while (true) {
					String line = bufferReader.readLine();
					handleRecievedData(line);
					System.out.println("client says: " + line);
				}
			}
		} catch (IOException e) {
			System.err.println("Failed to start server on port " + PORT);
//			e.printStackTrace();
		
			
			db.forEach((id, list) -> {
				System.out.println("Trcaking device ID: " + id);
				list.forEach(System.out::println);
			});
		} finally {

			if (serverSocket != null) {
				serverSocket.close();
			}
			if (bufferReader != null) {
				bufferReader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	private void handleRecievedData(String line) {
		String[] values = line.split(";");
		Location location = new Location(Float.valueOf(values[1]), Float.valueOf(values[2]),
				LocalDateTime.parse(values[3]));
		long id = Long.valueOf(values[0]);

		if (db.containsKey(id)) {
			db.get(id).add(location);
		} else {
			List<Location> locations = new LinkedList<>();
			locations.add(location);
			db.put(id, locations);
		}
	}

	public static void main(String[] args) throws IOException {
		Server server = new Server(8080);
		server.start();
	}
}
