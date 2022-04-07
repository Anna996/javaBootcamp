package javabootcamp.basic.exam;

public class Runner {

	// Question 1
	/*
	 * 
	 * JVM - java virtual machine 
	 * ���� ����� ��������� ������ �� ���� �� �'����
	 * �� ����� ������ ���� �� ���� ����� �� ���� �����.
	 * 
	 * JRE - java runtime environment 
	 * ���� �� ��'�����, ��� �� ������� ������� ���'����� ���� ���� ����.
	 * 
	 * JDK - java development kit 
	 * ��� ���� ����� �� ��'���� ������� ����������, ���� ���� ������ ������ �� �'���� ������� ����� ����� ������ ���.
	 * 
	 */

	// Question 2
	/*
	 
	 �� ��� �� ���� ��'����.
	 �������� ������� �� �'���� ����� �� ���� ���� ������ ���� �������.
	  ,��'������ ���� �� ���� �������, ���� �� �������� ����� - ����� ������ ������� 
	  ���� ����� ����� �� ���� �"� �� ���� ����� ���� ���� ����� ������ ���� ����.	
	 ����� ����� �� �'��, ����� �� ��� ��� ����� ������� ���� ���� �� ���� ������� )
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
