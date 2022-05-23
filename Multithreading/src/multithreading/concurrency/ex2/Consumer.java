package multithreading.concurrency.ex2;

import java.util.Queue;

public class Consumer implements Runnable {

	private final Queue<String> queue;

	public Consumer(Queue<String> queue) {
		this.queue = queue;
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
		synchronized (queue) {
			if (queue.isEmpty()) {
				queue.notify();
				System.out.println("Consumer is waiting...");
				queue.wait();
			}
			else {
				Thread.sleep(1000);
				String report = queue.remove();
				System.out.println("Consuming " + report);
			}
		}
	}

}
