package multithreading.concurrency.ThreadPoolExecutor.ex1;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		AliceFile aliceFile = new AliceFile();
		aliceFile.getMapOfWordCounter().forEach((word, counter) -> System.out.println(word + " : " + counter));
	}
}
