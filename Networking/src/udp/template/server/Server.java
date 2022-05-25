package udp.template.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * This is an implementation of a UDP server
 */
public class Server {
	private int port;
	private DatagramSocket serverSocket;
	private String clientMsg;
	private InetAddress clientAddress;
	int clientPort;
	private final static int INPUT_BUFFER_SIZE = 1024;

	public Server(int port) {
		this.port = port;
	}

	public void start() {
		try {
			serverSocket = new DatagramSocket(port);
			System.out.println("Server started on port " + port);
			System.out.println("Server is listening on port " + port);

			// listening to clients
			while (true) {
				receive();
				System.out.println("client "+ clientAddress + " sent: " + clientMsg);
				send();
				System.out.println("Server echo response sent");
			}

		} catch (SocketException e) {
			System.err.println("Server connection failed");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Server failed to connect with client");
			e.printStackTrace();
		}
	}

	public void receive() throws IOException {
		byte[] inputBuffer = new byte[INPUT_BUFFER_SIZE];
		DatagramPacket recievedPacket = new DatagramPacket(inputBuffer, INPUT_BUFFER_SIZE);
		
		// this is a blocking method
		serverSocket.receive(recievedPacket);

		// get client address info
		clientAddress = recievedPacket.getAddress();
		clientPort = recievedPacket.getPort();

		// get client message
		clientMsg = new String(recievedPacket.getData()).trim();
	}

	public void send() throws IOException {
		// prepare packet for sending
		byte[] myBytes = clientMsg.getBytes();
		DatagramPacket packetToSend = new DatagramPacket(myBytes, myBytes.length, clientAddress, clientPort);

		// send packet back to client
		serverSocket.send(packetToSend);
	}

	public static void main(String[] args) {
		Server server = new Server(4444);
		server.start();
	}
}
