package observer;

public class SMSListener implements NewsListener {
	private String phoneNumber;

	public SMSListener(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void getNewsReport(NewsType type, String report) {
		System.out.printf("%s news report sent SMS to number: %s --> Report: %s\n", type.toString(), phoneNumber, report);
	}
}
