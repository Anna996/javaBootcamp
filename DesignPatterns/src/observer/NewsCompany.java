package observer;

import java.util.HashMap;
import java.util.Map;

public class NewsCompany {
	private Map<NewsType, Report> allReports;

	public NewsCompany() {
		allReports = new HashMap<>();
		for (NewsType type : NewsType.values()) {
			allReports.put(type, new Report());
		}
	}

	public void publishNewsReport(NewsType type, String report) {
		allReports.get(type).notifyNews(type, report);
	}

	public void addNewListener(NewsType type, NewsListener listener) {
		allReports.get(type).subscribe(listener);
	}

	public void removeListener(NewsType type, NewsListener listener) {
		allReports.get(type).unsubscribe(listener);
	}
}
