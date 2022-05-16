package mvc;

public class Runner {

	public static void main(String[] args) {
		SystemView view = new SystemView();
		SystemController controller = new SystemController(view);
		controller.startSystem();
	}
}
