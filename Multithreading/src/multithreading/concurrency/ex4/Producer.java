package multithreading.concurrency.ex4;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {

	private Lock lock;
	private Condition condition;

	// final
	private final Queue<String> queue;
	private final int MAX_REPORTS;

	// static
	private static int counter = 0;

	public Producer(Queue<String> queue, int maxReports, Lock lock, Condition condition) {
		MAX_REPORTS = maxReports;
		this.queue = queue;
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		while (true) {
			try {
				produceData();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void produceData() throws InterruptedException {
		lock.lock();
		if (queue.size() == 1) {
			condition.signal();
		}
		if (queue.size() < MAX_REPORTS) {
			System.out.println("Producing Report " + counter++);
			Thread.sleep(2000);
			queue.add("Report " + counter);
		} else {
			System.out.println("producer is waiting...");
			condition.await();
		}
		lock.unlock();
	}
}
