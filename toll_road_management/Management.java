package toll_road_management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Management {

	private static TollRoad tollRoad = new TollRoad();

	public static void start() {
		final int SIZE = 5;
		List<CheckPoint> checkPoints = new ArrayList<>(SIZE);
		checkPoints.add(new CheckPoint("point 1", "holon 0", 0));
		checkPoints.add(new CheckPoint("point 2", "holon 1", 1));
		checkPoints.add(new CheckPoint("point 3", "holon 2", 2));
		checkPoints.add(new CheckPoint("point 4", "holon 3", 3));
		checkPoints.add(new CheckPoint("point 5", "holon 4", 4));

		Iterator<CheckPoint> checkPointsIterator = checkPoints.iterator();
		while (checkPointsIterator.hasNext()) {
			tollRoad.addCheckPoint(checkPointsIterator.next());
		}

		List<String> plateNumbers = new ArrayList<>();
		plateNumbers.add("111");
		plateNumbers.add("222");
		plateNumbers.add("333");
		plateNumbers.add("444");
		plateNumbers.add("555");

		Iterator<String> namesIterator = plateNumbers.iterator();
		List<Car> cars = new LinkedList<>();
		Random random = new Random();

		while (namesIterator.hasNext()) {
			int index = random.nextInt(SIZE);
			cars.add(new Car(namesIterator.next(), checkPoints.get(index), tollRoad.getIterator()));
		}
		
		int times = 5 , choise;
		Iterator<Car> carsIterator = cars.iterator();
		while(carsIterator.hasNext()) {
			Car curr = carsIterator.next();
			
			System.out.println("=====================");
			curr.printInfo();
			for (int i = 0; i < times; i++) {
				choise = random.nextInt(2);
				if(choise == 0) {
					if(!curr.previousCheckPoint()) {
						curr.nextCheckPoint();
					}
				}
				else {
					if(!curr.nextCheckPoint()) {
						curr.previousCheckPoint();
					}
				}
			}
			curr.printInfo();
		}
	}
}
