package observer;

import java.util.LinkedList;
import java.util.List;

public class Report {
	private List<NewsListener> listeners;

	public Report() {
		listeners = new LinkedList<>();
	}

	public void subscribe(NewsListener listener) {
		listeners.add(listener);
	}

	public void unsubscribe(NewsListener listener) {
		listeners.remove(listener);
	}
	
	public void notifyNews(NewsType type, String report) {
		listeners.forEach(listener -> listener.getNewsReport(type, report));
	}
}
