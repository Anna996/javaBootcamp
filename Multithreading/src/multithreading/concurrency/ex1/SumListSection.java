package multithreading.concurrency.ex1;

public class SumListSection implements Runnable {

	private int start;
	private int end;
	private Runner runner;

	public SumListSection(int start, int end, Runner runner) {
		this.start = start;
		this.end = end;
		this.runner = runner;
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			
			// synchronized keyword in a block
			synchronized (runner) {
				runner.addToSum(i);
			}
			
			// synchronized keyword in a method
//			runner.addToSum(i);
		}
	}
}
