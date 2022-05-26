package tcp.ex3_tracking_device;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Client {

	private String serverName;
	private int serverPort;
	private Socket clientSocket = null;
	private PrintWriter writer = null;
	private BufferedReader bufferReader = null;
	private TrackingDevice device;
	private float longitude = 0;
	private float altitude = 0;

	public Client(String serverName, int serverPort) {
		this.serverName = serverName;
		this.serverPort = serverPort;
		device = new TrackingDevice();
	}

	public void start() throws IOException {
		try {
			initConnection();
			System.out.println("Connected to server");

			while (true) {
				longitude += 0.2f;
				altitude -= 0.2f;
				device.updateLocation(longitude, altitude, LocalDateTime.now());
				writer.println(device.getInfo());
				sleep(10000);
			}
		} catch (UnknownHostException e) {
			System.err.println("Server is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Socket failed");
			e.printStackTrace();
		} finally {
			if (clientSocket != null) {
				clientSocket.close();
			}
			if (writer != null) {
				writer.close();
			}
			if (bufferReader != null) {
				bufferReader.close();
			}
		}
	}

	private void initConnection() throws UnknownHostException, IOException {
		clientSocket = new Socket(serverName, serverPort);
		writer = new PrintWriter(clientSocket.getOutputStream(), true);
		bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		Client client = new Client("localhost", 8080);
		client.start();
	}
}
