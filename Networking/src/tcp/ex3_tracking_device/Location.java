package tcp.ex3_tracking_device;

import java.time.LocalDateTime;

public class Location {
	private float longitude;
	private float altitude;
	private LocalDateTime timestamp;

	public Location(float longitude, float altitude, LocalDateTime timestamp) {
		this.longitude = longitude;
		this.altitude = altitude;
		this.timestamp = timestamp;
	}

//	public Location(float longitude, float altitude) {
//		this(longitude, altitude, LocalDateTime.now());
//	}

	public float getLongitude() {
		return longitude;
	}

	public float getAltitude() {
		return altitude;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "Location [longitude=" + longitude + ", altitude=" + altitude + ", timestamp=" + timestamp + "]";
	}
}
