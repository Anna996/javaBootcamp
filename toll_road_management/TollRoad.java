package toll_road_management;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TollRoad {
	private List<CheckPoint> list;

	public TollRoad() {
		this.list = new LinkedList<>();
	}

	public void addCheckPoint(CheckPoint checkPoint) {
		if (checkPoint == null)
			return;

		int addAtIndex = checkPoint.getPosition();

		if (addAtIndex < 0) {
			addAtIndex = 0;
		} else if (addAtIndex > list.size()) {
			addAtIndex = list.size();
		}
		list.add(addAtIndex, checkPoint);
	}

	public void removeCheckPoint(int index) {
		if (index >= 0 && index < list.size()) {
			list.remove(index);
		}
	}
	
	public ListIterator<CheckPoint> getIterator() {
		return list.listIterator();
	}
}
