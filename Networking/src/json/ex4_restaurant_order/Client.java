package json.ex4_restaurant_order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.google.gson.Gson;

public class Client {
	private String serverName;
	private int serverPort;
	private Socket clientSocket = null;
	private PrintWriter writer = null;
	private BufferedReader bufferReader = null;

	public Client(String serverName, int serverPort) {
		this.serverName = serverName;
		this.serverPort = serverPort;
	}

	public void start() throws IOException {
		try {
			initConnection();
			System.out.println("Connected to server");
			
			Order order1 = new Order();
			order1.addDish(Dish.MEAT);
			order1.addDish(Dish.CAKE);
			
			Order order2 = new Order();
			order2.addDish(Dish.SALAD);
			order2.addDish(Dish.SALAD);
			order2.addDish(Dish.CAKE);
			order2.addDish(Dish.ICE_CREAM);
			
			send(order1);
			System.out.println(bufferReader.readLine());
			send(order2);
			System.out.println(bufferReader.readLine());
			
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
			System.out.println("Disconnected");
		}
	}

	private void initConnection() throws UnknownHostException, IOException {
		clientSocket = new Socket(serverName, serverPort);
		writer = new PrintWriter(clientSocket.getOutputStream(), true);
		bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	private void send(Order order) throws IOException {
		Gson gson = new Gson();
		String jsonOrder = gson.toJson(order,Order.class);
		
		writer = new PrintWriter(clientSocket.getOutputStream(), true);
		writer.println(jsonOrder);
	}
	
	public static void main(String[] args) throws IOException {
		Client client = new Client("localhost", 8080);
		client.start();
	}
}
