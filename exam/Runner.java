package javabootcamp.basic.exam;

public class Runner {

	// Question 1
	/*
	 * 
	 * JVM - java virtual machine 
	 * זוהי סביבה וירטואלית שמריצה את הקוד של ג'אווה
	 * זה הרכיב שבפועל מקבל את הקוד וגורם לו לרוץ במעבד.
	 * 
	 * JRE - java runtime environment 
	 * מכיל את הג'יביאם, ואת כל הספריות הנוספות שהג'יביאם צריך בזמן ריצה.
	 * 
	 * JDK - java development kit 
	 * זהו רכיב שמכיל את הג'אווה ראנטיים אינביירמנט, והוא מכיל ספריות נוספות של ג'אווה שעוזרות למפתח לכתוב תוכנית קוד.
	 * 
	 */

	// Question 2
	/*
	 
	 יש לנו את הקוד בג'אווה.
	 קומפיילר שקוראים לו ג'אווכ מקמפל את הקוד לשפת ביניים ששמה בייתקוד.
	  ,הג'יוויאם מקבל את הקוד המקומפל, מחפש את פונקציית המאין - נקודת הכניסה לתוכנית 
	  ומשם מתחיל להריץ את הקוד ע"י כך שהוא מקמפל אותו לשפת מכונה והמעבד מריץ אותו.	
	 מקמפל בצורה של ג'יט, כלומר רק פעם אחת ובפעם הראשונה שהוא צריך את הקוד המסויים )
	 (
	
	*/

	// Question 3
	public static boolean isPalindrome(int num) {
		int copyNum = num, reversedNum = 0;

		while (copyNum > 0) {
			reversedNum *= 10;
			reversedNum += copyNum % 10;
			copyNum /= 10;
		}

		while (num > 0) {
			if (num % 10 != reversedNum % 10) {
				return false;
			}
			num /= 10;
			reversedNum /= 10;
		}
		return true;
	}

	// Question 4
	// The concatenated array has two more elements at the end :
	// sum of both sums and absolute difference.
	public static int[] getConcatenatedArrayWithSmallerSumFirstPlus(int[] nums1, int[] nums2) {
		int totalLength = nums1.length + nums2.length + 2;
		int[] concatArray = new int[totalLength];
		int sum1 = getSumOfElements(nums1), sum2 = getSumOfElements(nums2);

		int[] shorterArr = nums1, longerArr = nums2;
		if (sum1 > sum2) {
			shorterArr = nums2;
			longerArr = nums1;
		}

		int idx;
		idx = insertIntoFirstArrTheElementsOfSecondArrAtIndex(concatArray, shorterArr, 0);
		idx = insertIntoFirstArrTheElementsOfSecondArrAtIndex(concatArray, longerArr, idx);

		// Last Two elements
		concatArray[totalLength - 2] = sum1 + sum2;
		concatArray[totalLength - 1] = Math.abs(sum1 - sum2);
		return concatArray;
	}

	public static int getSumOfElements(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}
		return sum;
	}

	public static int insertIntoFirstArrTheElementsOfSecondArrAtIndex(int[] firstArr, int[] secondArr, int index) {
		for (int val : secondArr) {
			firstArr[index] = val;
			index++;
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Question 3
		int num = 12221;
		String isPoli = isPalindrome(num) ? " " : " NOT ";
		System.out.println(num + " is" + isPoli + "palindrom");

		// Question 4
		int[] nums1 = { 7, 8, -4 }, nums2 = { -5, 7, 3, 2 };
		int[] concatArray = getConcatenatedArrayWithSmallerSumFirstPlus(nums1, nums2);

		// print
		for (int val : concatArray) {
			System.out.print(val + " ");
		}
	}
}
