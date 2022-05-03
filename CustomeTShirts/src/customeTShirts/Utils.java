package customeTShirts;

public class Utils {

	public static boolean isInRange(int val, int min, int max) {
		return  val >= min && val <= max;
	}
	
	public static boolean isInRange(double val, double min, double max) {
		return val >= min && val <= max;
	}

	public static boolean isInRange(short val, short min, short max) {
		return val >= min && val <= max;
	}
	
	public static boolean hasOnlyDigitsOrLetter(String str) {
		if (str == null) {
			return false;
		}

		str = str.replaceAll("\\s", "");
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetterOrDigit(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}
}
