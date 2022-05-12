package builder;

public class Director {

	public void createHawaiianPizza(Builder builder) {
		builder.setType(Type.PIZZA);
		builder.setVersion(Version.HAWAIIAN);
		builder.setMozzarella(100);
		builder.setFeta(40);
		builder.setMushrooms(20);
		builder.setPineapple(25);
	}

	public void createDominicanPuffPastry(Builder builder) {
		builder.setType(Type.PUFF_PASTRY);
		builder.setVersion(Version.DOMINICAN);
		builder.setMozzarella(10);
		builder.setFeta(100);
		builder.setMushrooms(20);
		builder.setPineapple(15);
	}
}
