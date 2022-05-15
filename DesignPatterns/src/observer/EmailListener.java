package observer;

public class EmailListener implements NewsListener {
	private String email;

	public EmailListener(String email) {
		this.email = email;
	}

	@Override
	public void getNewsReport(NewsType type, String report) {
		System.out.printf("%s news report sent to email: %s --> Report: %s\n", type.toString(), email, report);
	}
}
