package builder;

public interface Builder {

	void setType(Type type);

	void setVersion(Version version);

	void setMozzarella(float mozzarella);

	void setFeta(float feta);

	void setMushrooms(float mushrooms);

	void setPineapple(float pineapple);

	Pastry getResult();
}
