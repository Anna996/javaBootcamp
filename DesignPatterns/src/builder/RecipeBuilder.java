package builder;

public class RecipeBuilder implements Builder {
	private Type type;
	private Version version;
	private float mozzarella;
	private float feta;
	private float mushrooms;
	private float pineapple;

	@Override
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public void setVersion(Version version) {
		this.version = version;
	}

	@Override
	public void setMozzarella(float mozzarella) {
		this.mozzarella = mozzarella;
	}

	@Override
	public void setFeta(float feta) {
		this.feta = feta;
	}

	@Override
	public void setMushrooms(float mushrooms) {
		this.mushrooms = mushrooms;
	}

	@Override
	public void setPineapple(float pineapple) {
		this.pineapple = pineapple;
	}

	@Override
	public Pastry getResult() {
		return new Pastry(type, version, mozzarella, feta, mushrooms, pineapple);
	}
}
