package builder;

public class Pastry {
	private Type type;
	private Version version;
	private float mozzarella;
	private float feta;
	private float mushrooms;
	private float pineapple;

	public Pastry(Type type, Version version, float mozzarella, float feta, float mushrooms, float pineapple) {
		this.type = type;
		this.version = version;
		this.mozzarella = mozzarella;
		this.feta = feta;
		this.mushrooms = mushrooms;
		this.pineapple = pineapple;
	}

	public String created() {
		return String.format("Pastry created: %s %s", type, version);
	}

	@Override
	public String toString() {
		return "Pastry [type=" + type + ", version=" + version + ", mozzarella=" + mozzarella + ", feta=" + feta
				+ ", mushrooms=" + mushrooms + ", pineapple=" + pineapple + "]";
	}
}
