package multithreading.concurrency.ForkJoinPool.ex2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Runner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		double[] arr = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		SumTask task = new SumTask(arr, 0, arr.length - 1);

		ForkJoinPool pool = new ForkJoinPool();
		Future<Double> sumFuture = pool.submit(task);
		System.out.println("The sum is: " + sumFuture.get());

		// Check answer
		double sum = 0;
		for (double val : arr) {
			sum += val;
		}
		System.out.println("Check: " + sum);
	}
}