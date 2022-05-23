package multithreading.concurrency.ex2;

import java.util.LinkedList;
import java.util.Queue;

public class Service {
	private Queue<String> dataBase;
	private final int MAX_REPORTS = 5;
	
	public Service() {
		dataBase = new LinkedList<>();
	}
	
	public void start() {
		Thread producer = new Thread(new Producer(dataBase, MAX_REPORTS));
		Thread consumer = new Thread(new Consumer(dataBase));
		
		producer.start();
		consumer.start();
	}
}
