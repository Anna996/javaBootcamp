package multithreading.concurrency.ex4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
	private Queue<String> dataBase;
	private final int MAX_REPORTS = 5;

	public Service() {
		dataBase = new LinkedList<>();
	}

	public void start() {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Thread producer = new Thread(new Producer(dataBase, MAX_REPORTS, lock, condition));
		Thread consumer = new Thread(new Consumer(dataBase, lock, condition));

		producer.start();
		consumer.start();
	}
}
