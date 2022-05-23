package multithreading.concurrency.ForkJoinPool.ex2;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Double> {

	private double[] arr;
	private int low;
	private int high;

	public SumTask(double[] arr, int low, int high) {
		this.arr = arr;
		this.low = low;
		this.high = high;
	}

	@Override
	protected Double compute() {
		if (low == high) {
			return arr[low];
		}

		int mid = (low + high) / 2;
		SumTask leftTask = new SumTask(arr, low, mid);
		SumTask rightTask = new SumTask(arr, mid + 1, high);

		leftTask.fork();
		rightTask.fork();

		return leftTask.join() + rightTask.join();
	}
}
