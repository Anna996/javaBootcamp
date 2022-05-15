package observer;

import java.util.Arrays;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		NewsCompany newsCompany = new NewsCompany();

		List<NewsListener> users = Arrays.asList(
				new SMSListener("0545225227"),
				new EmailListener("admin@example.com"),
				new SMSListener("0545555556"),
				new EmailListener("anna@example.com")
				);

		// Subscribe all users
		users.forEach(user -> newsCompany.addNewListener(NewsType.SPORT, user));
		
		newsCompany.addNewListener(NewsType.GENERAL, users.get(0));
		newsCompany.addNewListener(NewsType.GENERAL, users.get(2));
		newsCompany.addNewListener(NewsType.WEATHER, users.get(1));
		newsCompany.addNewListener(NewsType.WEATHER, users.get(3));
		
		// Publish reports
		newsCompany.publishNewsReport(NewsType.SPORT, "Linoy Ashram Won !!");
		newsCompany.publishNewsReport(NewsType.GENERAL, "Dubai and Israel are friends now ? ");
		newsCompany.publishNewsReport(NewsType.WEATHER, "Today will be rainny");
	}
}
