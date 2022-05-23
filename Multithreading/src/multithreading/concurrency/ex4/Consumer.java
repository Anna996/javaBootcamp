package multithreading.concurrency.ex4;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {

	private final Queue<String> queue;
	private Lock lock;
	private Condition condition;

	public Consumer(Queue<String> queue, Lock lock, Condition condition) {
		this.queue = queue;
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		while (true) {
			try {
				consumeData();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consumeData() throws InterruptedException {
		lock.lock();
		if (queue.isEmpty()) {
			condition.signal();
			System.out.println("Consumer is waiting...");
			condition.await();
		} else {
			Thread.sleep(1000);
			String report = queue.remove();
			System.out.println("Consuming " + report);
		}
		lock.unlock();
	}
}
