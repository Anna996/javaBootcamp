package json.ex4_restaurant_order;

public enum Dish{
	MEAT(55), SALAD(36), CAKE(22), ICE_CREAM(16);
	
	private float price;
	
	 Dish(float price) {
		this.price = price;
	}
	 
	 public float getPrice() {
		 return price;
	 }
}
