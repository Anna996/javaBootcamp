package tcp.ex3_tracking_device;

import java.time.LocalDateTime;

public class TrackingDevice {
	private final long ID;
	private static long counter = 1000;
	private Location location;
	
	public TrackingDevice() {
		ID = counter++;
	}
	
	public void updateLocation(float longitude, float altitude, LocalDateTime timestamp) {
		location = new Location(longitude, altitude,timestamp);
	}
	
	public String getInfo() {
		return String.format("%s;%f;%f;%s", ID, location.getLongitude(), location.getAltitude(),location.getTimestamp());
	}	
}
