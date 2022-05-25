package udp.ex2_weather_server;

import java.util.Objects;

public class Forecast {
	private String city;
	private float temperature;
	private float humidity;

	public Forecast(String city, float temperature, float humidity) {
		this.city = city;
		this.temperature = temperature;
		this.humidity = humidity;
	}

	public String getCity() {
		return city;
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Forecast other = (Forecast) obj;
		return Objects.equals(city, other.city);
	}
}
