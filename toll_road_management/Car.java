package toll_road_management;

import java.util.ListIterator;
import java.util.Objects;

public class Car {
	private String plateNumber;
	private ListIterator<CheckPoint> iterator;
	private CheckPoint currentCheckPoint;
	private int totalFee;

	public Car(String plateNumber, CheckPoint currentCheckPoint, ListIterator<CheckPoint> iterator) {
		setPlateNumber(plateNumber);
		setCurrentCheckPoint(currentCheckPoint);
		setIterator(iterator);
		setTotalFee(0);
	}

	private void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	private void setIterator(ListIterator<CheckPoint> iterator) {
		while (iterator.hasNext()) {
			if (iterator.next() == currentCheckPoint) {
				this.iterator = iterator;
				break;
			}
		}
	}

	private void setCurrentCheckPoint(CheckPoint currentCheckPoint) {
		this.currentCheckPoint = currentCheckPoint;
	}

	private void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public boolean nextCheckPoint() {
		if (iterator.hasNext()) {
			setCurrentCheckPoint(iterator.next());
			addFee();
			System.out.println("next");
			return true;
		}
		return false;
	}

	public boolean previousCheckPoint() {
		boolean hasPrev = false;
		
		iterator.previous();

		if (iterator.hasPrevious()) {
			setCurrentCheckPoint(iterator.previous());
			addFee();
			System.out.println("previous");
			hasPrev = true;
		}
		
		iterator.next();
		return hasPrev;
	}

	private void addFee() {
		setTotalFee(totalFee + currentCheckPoint.FEE);
	}

	public void printInfo() {
		System.out.printf("Plate Number: %s , Location: %s , Total fee: %d\n", plateNumber,
				currentCheckPoint.getAddress(), totalFee);
	}
}
