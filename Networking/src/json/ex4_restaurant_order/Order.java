package json.ex4_restaurant_order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order {
	private final long ORDER_NUMBER;
	private static long counter = 1000;
	private List<Dish> dishes;

	public Order() {
		ORDER_NUMBER = counter++;
		dishes = new ArrayList<>();
	}

	public void addDish(Dish dish) {
		dishes.add(dish);
	}

	public long getORDER_NUMBER() {
		return ORDER_NUMBER;
	}

	@Override
	public String toString() {
		return "Order [ORDER_NUMBER=" + ORDER_NUMBER + ", dishes=" + dishes + "]";
	}
	
	public Iterator<Dish> getDishesIterator() {
		return dishes.iterator();
	}
}
