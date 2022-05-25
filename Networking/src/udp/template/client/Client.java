package udp.template.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private int port;
	private Scanner scanner;
	private String serverName;
	private int serverPort;
	private DatagramSocket clientSocket;
	private String dataToSend;
	private String serverMsg;

	private final static int INPUT_BUFFER_SIZE = 1024;

	public Client(int port, String serverName, int serverPort) {
		this.port = port;
		this.serverName = serverName;
		this.serverPort = serverPort;
		scanner = new Scanner(System.in);
		clientSocket = null;
		dataToSend = null;
	}

	public void start() {
		try {
			// creating client socket
			clientSocket = new DatagramSocket(port);
			System.out.println("Client started on port " + port);

			do {
				// creating data
				System.out.println("Enter a message to send:");
				dataToSend = scanner.nextLine();
				send();
				receive();
				System.out.println("Server response: " + serverMsg);

			} while (!dataToSend.toLowerCase().equals("quit"));

		} catch (SocketException e) {
			System.err.println("client socket creation failed");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			System.err.println("server address could not be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("sending data failed");
			e.printStackTrace();
		} finally {
			System.out.println("client disconnected");
			disconnect();
		}
	}

	public void send() throws IOException {
		// creating datagram packet
		byte[] messageBytes = dataToSend.getBytes();
		DatagramPacket packetToSend = new DatagramPacket(messageBytes, messageBytes.length,
				InetAddress.getByName(serverName), serverPort);

		// send packet
		clientSocket.send(packetToSend);
	}

	public void receive() throws IOException {
		// prepare packet for receiving data from server
		byte[] buffer = new byte[INPUT_BUFFER_SIZE];
		DatagramPacket receivedPacket = new DatagramPacket(buffer, INPUT_BUFFER_SIZE);

		// receive data from server
		clientSocket.receive(receivedPacket);

		// extract message from packet
		serverMsg = new String(receivedPacket.getData(), receivedPacket.getOffset(), receivedPacket.getLength()).trim();
	}

	public void disconnect() {
		scanner.close();
		if (clientSocket != null) {
			clientSocket.close();
		}
	}

	public static void main(String[] args) {
		Client client = new Client(4445, "localhost", 4444);
		client.start();
	}
}
