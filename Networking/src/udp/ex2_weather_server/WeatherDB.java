package udp.ex2_weather_server;

import java.util.HashMap;
import java.util.Map;

public class WeatherDB {
	private Map<String, Forecast> forecasts;

	public WeatherDB() {
		forecasts = new HashMap<>();
	}

	public void initDefault() {
		forecasts.put("holon", new Forecast("Holon", 22.5f, 10.8f));
		forecasts.put("tel-Aviv", new Forecast("Tel-Aviv", 25, 12));
		forecasts.put("london", new Forecast("London", 16.5f, 5.3f));
		forecasts.put("spain", new Forecast("Spain", 20, 8));
		forecasts.put("rome", new Forecast("Rome", 24.2f, 8.5f));
	}
	
	private Forecast getForecast(String name) {
		return forecasts.get(name.toLowerCase());
	}

	public boolean isExists(String name) {
		return forecasts.containsKey(name.toLowerCase());
	}

	public float getTemperature(String name) {
		return getForecast(name).getTemperature();
	}

	public float getHumidity(String name) {
		return getForecast(name).getHumidity();
	}
	
	public String getCityName(String name) {
		return getForecast(name).getCity();
	}
}
