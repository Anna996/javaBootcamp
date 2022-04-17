package bootcam.design.flight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
	private final long FLIGHT_NUMBER;
	private static long flightCounter = 0;
	protected LocalTime departureTime;
	protected LocalTime actualDepartureTime;
	protected LocalDate departureDate;
	protected int flightDuration;
	protected int minutesOfDelay;
	private FrequentFlyer[] frequentFlyers;
	private int amountOfCredit;
	private int miles;

	public Flight(LocalTime departureTime, LocalDate departureDate, int flightDuration, FrequentFlyer[] frequentFlyers,
			int amountOfCredit, int miles) {
		this.FLIGHT_NUMBER = flightCounter++;
		setDepartureTime(departureTime);
		setDepartureDate(departureDate);
		setFlightDuration(flightDuration);
		setFrequentFlyers(frequentFlyers);
		setAmountOfCredit(amountOfCredit);
		setMiles(miles);
		actualDepartureTime = this.departureTime;
		minutesOfDelay = 0;
	}

	private void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	private void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	private void setFlightDuration(int flightDuration) {
		this.flightDuration = flightDuration;
	}

	private void setFrequentFlyers(FrequentFlyer[] frequentFlyers) {
		if (frequentFlyers.length > 200) {
			System.out.println("Max Flyers can be 200 people.");
			return;
		}
		this.frequentFlyers = frequentFlyers;
	}

	public long getFLIGHT_NUMBER() {
		return FLIGHT_NUMBER;
	}

	private void setAmountOfCredit(int amountOfCredit) {
		this.amountOfCredit = amountOfCredit;
	}

	public int getAmountOfCredit() {
		return amountOfCredit;
	}

	public int getMiles() {
		return miles;
	}

	private void setMiles(int miles) {
		this.miles = miles;
	}

	public void delayFlight(int minutes) {
		minutesOfDelay += minutes;
		actualDepartureTime = departureTime.plusMinutes(minutesOfDelay);
	}

	public LocalTime getArrivalTime() {
		return actualDepartureTime;
	}
}
