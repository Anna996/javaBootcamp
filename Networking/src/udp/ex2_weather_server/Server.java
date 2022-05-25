package udp.ex2_weather_server;

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
	private String lastCityName;
	private InetAddress clientAddress;
	int clientPort;
	private WeatherService service;
	private String respondMsg;
	private final static int INPUT_BUFFER_SIZE = 1024;

	public Server(int port) {
		this.port = port;
		service = new WeatherService();
		service.initDefault();
	}

	public void start() {
		try {
			serverSocket = new DatagramSocket(port);
			System.out.println("Server started on port " + port);
			System.out.println("Server is listening on port " + port);

			// listening to clients
			while (true) {
				receive();
				System.out.println("client " + clientAddress + " sent: " + clientMsg);
				
				boolean isExist = service.isExists(clientMsg);
				respondMsg = isExist
						? "Select the type of data you wish to get:\n1. Temperature 2. Humidity 3. Temperature and humidity\n"
						: "The city does not exists in the data";
				send();
				
				if (isExist) {
					lastCityName = getCityName();
					receive();
					handleRequest();
					send();
				} 
	
				System.out.println("Server response sent");
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
		byte[] myBytes = respondMsg.getBytes();
		DatagramPacket packetToSend = new DatagramPacket(myBytes, myBytes.length, clientAddress, clientPort);

		// send packet back to client
		serverSocket.send(packetToSend);
	}

	private void handleRequest() throws IOException {
		int input = Integer.valueOf(clientMsg);
		
		respondMsg = lastCityName + ": ";
		switch(input) {
		case 1:
			respondMsg += getTemperature();
			break;
		case 2:
			respondMsg += getHumidity();
			break;
		case 3:
			respondMsg += getTemperature() + " , " + getHumidity();
		}
	}
	
	private String getCityName() {
		return service.getCityName(clientMsg);
	}
	
	private String getTemperature() {
		return "Temperature: " + service.getTemperature(lastCityName) + "c";
	}
	
	private String getHumidity() {
		return "Humidity: " + service.getHumidity(lastCityName) + "%";
	}

	public static void main(String[] args) {
		Server server = new Server(4444);
		server.start();
	}
}
