package bootcam.design.flight;

public class FrequentFlyer {
	private final long FREQUENT_FLYER_NUMBER;
	private String firstName;
	private String lastName;
	private static long frequentCounter = 0;
	private MileageCredit mileageCredit;

	public FrequentFlyer(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
		this.FREQUENT_FLYER_NUMBER = frequentCounter++;
		this.mileageCredit = new MileageCredit(this);
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getFREQUENT_FLYER_NUMBER() {
		return FREQUENT_FLYER_NUMBER;
	}
	
	public void addFlight(Flight flight) {
		mileageCredit.updateCredit(flight);
	}
	
	public int getMileageCreditAmount() {
		return mileageCredit.getCreditAmount();
	}
}
