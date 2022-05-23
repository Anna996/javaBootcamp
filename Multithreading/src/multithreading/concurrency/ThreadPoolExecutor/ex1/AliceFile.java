package multithreading.concurrency.ThreadPoolExecutor.ex1;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AliceFile {
	private static final String FILE_NAME = "src\\multithreading\\concurrency\\ThreadPoolExecutor\\files\\alice.txt";
	private BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<>(10);
	private ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 6, 5, TimeUnit.SECONDS, tasks,
			new ThreadPoolExecutor.CallerRunsPolicy());
	private Map<String, Integer> wordsCounterMap;
	private Lock lock = new ReentrantLock();

	public AliceFile() {
		wordsCounterMap = new HashMap<>();
	}

	public Map<String, Integer> getMapOfWordCounter() throws InterruptedException {
		File file = new java.io.File(FILE_NAME);

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNext()) {
				String[] notCleanWords = scanner.nextLine().split(" ");
				String[] words = clean(notCleanWords);

				pool.execute(() -> {
					for (String word : words) {
						lock.lock();
						if (wordsCounterMap.containsKey(word)) {
							int counter = 1 + wordsCounterMap.get(word);
							wordsCounterMap.replace(word, counter);
						} else {
							wordsCounterMap.put(word, 1);
						}
						lock.unlock();
					}
				});
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		pool.shutdown();
		pool.awaitTermination(30, TimeUnit.SECONDS);
		return wordsCounterMap;
	}

	private String[] clean(String[] words) {
		String[] cleanedWords = new String[words.length];
		int idx = 0;

		for (String word : words) {
			String cleanWord = "";
			word = word.toLowerCase();
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (Character.isLetter(c)) {
					cleanWord += c;
				}
			}

			cleanedWords[idx++] = cleanWord;
		}

		return cleanedWords;
	}
}
