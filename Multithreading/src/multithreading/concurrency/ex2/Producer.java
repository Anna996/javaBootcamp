package multithreading.concurrency.ex2;

import java.util.Queue;

public class Producer implements Runnable {
	private final Queue<String> queue;
	private final int MAX_REPORTS;
	private static int counter;

	public Producer(Queue<String> queue, int maxReports) {
		MAX_REPORTS = maxReports;
		this.queue = queue;
		counter = 0;
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
		synchronized (queue) {
			if(queue.size() == 1) {
				queue.notify();
			}
			if (queue.size() < MAX_REPORTS) {
				System.out.println("Producing Report " + counter++);
				Thread.sleep(2000);
				queue.add("Report " + counter);
			}
			else {
				System.out.println("producer is waiting...");
				queue.wait();
			}
		}
	}
}
