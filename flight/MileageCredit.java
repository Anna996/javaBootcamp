package bootcam.design.flight;

public class MileageCredit {
	private Flight[] flights;
	private FrequentFlyer frequentFlyer;
	private int creditAmount;

	public MileageCredit(FrequentFlyer frequentFlyer) {
		setFrequentFlyer(frequentFlyer);
		setCreditAmount(0);
		flights = new Flight[0];
	}

	private void setFrequentFlyer(FrequentFlyer frequentFlyer) {
		this.frequentFlyer = frequentFlyer;
	}

	private void setCreditAmount(int creditAmount) {
		this.creditAmount = creditAmount;
	}

	public int getCreditAmount() {
		return creditAmount;
	}

	private void addFlight(Flight flight) {
		Flight[] updatedArr = new Flight[flights.length + 1];
		int i = 0;

		for (Flight element : flights) {
			updatedArr[i++] = element;
		}

		updatedArr[i] = flight;
		flights = updatedArr;
	}

	public void updateCredit(Flight flight) {
		addFlight(flight);

		int creditAmount = flight.getAmountOfCredit();
		int miles = flight.getMiles();
		float milesPercent = 0.8f;
		float base = milesPercent * miles * creditAmount;
		float bonus = (1 - milesPercent) * miles * creditAmount * 1.3f;
		int total = (int) (base + bonus);

		setCreditAmount(creditAmount + total);
	}
}
