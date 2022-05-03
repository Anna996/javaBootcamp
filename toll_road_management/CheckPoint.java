package toll_road_management;

public class CheckPoint {
	private String name;
	private String address;
	private int position;
	public final int FEE = 5;
	
	public CheckPoint(String name, String address, int position) {
		this.name = name;
		this.address = address;
		this.position = position;
	}

	public String getAddress() {
		return address;
	}

	public int getPosition() {
		return position;
	}	
}
