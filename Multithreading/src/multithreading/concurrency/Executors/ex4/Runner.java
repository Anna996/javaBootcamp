package multithreading.concurrency.Executors.ex4;

import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
	private static ExecutorService service = Executors.newFixedThreadPool(4);
	private static List<Future<Integer>> futureCounters = new LinkedList<>();
	private final static String WORD = "java";

	public static void main(String[] args) {
		handleUrlConnection();
	}

	public static void handleUrlConnection() {
		try {
			URL url = new URL("https://en.wikipedia.org/wiki/Java_(programming_language)");
			URLConnection urlConnection = url.openConnection();
			Scanner scanner = new Scanner(urlConnection.getInputStream());

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				handleLine(line);
			}

			int sum = 0;
			for (Future<Integer> future : futureCounters) {
				sum += future.get();
			}
			
			System.out.println("The sum is: " + sum);
			scanner.close();
			service.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private static void handleLine(String line) {
		Callable<Integer> callable = () -> {
			return (int)(Arrays.asList(line.split(" "))
			.stream()
			.map(word -> word.toLowerCase())
			.filter(word -> word.equals(WORD))
			.count());
		};

		Future<Integer> future = service.submit(callable);
		futureCounters.add(future);
	}
}