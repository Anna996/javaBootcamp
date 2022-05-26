package json.ex4_restaurant_order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import serialization.db.Student;

/*
 * This is an implementation of a TCP server
 */
public class Server {
	private final int PORT;

	private ServerSocket serverSocket = null;
	private BufferedReader bufferReader = null;
	private PrintWriter writer = null;

	public Server(int port) {
		PORT = port;
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

				bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				writer = new PrintWriter(clientSocket.getOutputStream(), true);

				Gson gson = new Gson();

				while (!clientSocket.isClosed()) {
					String json = bufferReader.readLine();
					
					if(json == null) {
						clientSocket.close();
						continue;
					}
					
					Order order = gson.fromJson(json, Order.class);
					float price = handleRecievedData(order);
					writer.println("Order number %d : %.2f shekels".formatted(order.getORDER_NUMBER(), price));
					System.out.println("Recieved: " + order);
				}
			}
		} catch (IOException e) {
			System.err.println("Failed to start server on port " + PORT);
			e.printStackTrace();
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

	private float handleRecievedData(Order order) {
		Iterator<Dish> iterator = order.getDishesIterator();
		float price = 0;

		while (iterator.hasNext()) {
			price += iterator.next().getPrice();
		}

		return price;
	}

	public static void main(String[] args) throws IOException {
		Server server = new Server(8080);
		server.start();
	}
}
