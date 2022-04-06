package javabootcamp.basic.Ex_6;

import java.util.Scanner;

public class Runner {

	// question 1
	public static int addOneToEachDigit(int num) {
		int result = 0, pow = 1, currDigit;

		while (num > 0) {
			currDigit = (num % 10) + 1;
			currDigit %= 10;
			result += currDigit * pow;
			pow *= 10;
			num /= 10;
		}
		return result;
	}

	// question 2
	public static int getSmallestDigitsIfLengthIsEquall(int num1, int num2) {
		int curr1, curr2, min, result = 0, pow = 1;

		while (num1 > 0 && num2 > 0) {
			curr1 = num1 % 10;
			curr2 = num2 % 10;
			min = curr1 < curr2 ? curr1 : curr2;
			result += min * pow;
			pow *= 10;
			num1 /= 10;
			num2 /= 10;
		}
		return (num1 > 0 || num2 > 0) ? -1 : result;
	}

	// question 3
	public static boolean isPerfect(int num) {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		return sum == num;
	}

	// question 4
	public static int getSumOfDigits(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public static int numOfElementsWithSumOfDigits10(int[] arr) {
		int count = 0;
		for (int val : arr) {
			if (getSumOfDigits(val) == 10) {
				count++;
			}
		}
		return count;
	}

	// question 5
	public static void printRhombus(char pattern, int num) {
		for (int i = 0; i < num; i++) {
			printPatterns(pattern, num, i, 0);
			printSpaces(pattern, num, i, 0);
			printPatterns(pattern, num, i, 0);
			System.out.println(" ");
		}
		for (int i = num - 1; i > 0; i--) {
			printPatterns(pattern, num, i, 1);
			printSpaces(pattern, num, i, 2);
			printPatterns(pattern, num, i, 1);
			System.out.println(" ");
		}
	}

	public static void printPatterns(char pattern, int num, int i, int toAdd) {
		for (int j = 0; j < num - i + toAdd; j++) {
			System.out.print(pattern);
		}
	}

	public static void printSpaces(char pattern, int num, int i, int j) {
		for (; j < i * 2; j++) {
			System.out.print(" ");
		}
	}

	// question 6
	public static boolean isSumRowEquallToSumCol(int[][] matrix) {
		int sumRow, sumCol, n = matrix.length;

		for (int i = 0; i < n; i++) {
			sumRow = 0;
			sumCol = 0;
			// check row:
			for (int col = 0; col < n; col++) {
				sumRow += matrix[i][col];
			}
			// check col:
			for (int row = 0; row < n; row++) {
				sumCol += matrix[row][i];
			}
			if (sumRow != sumCol)
				return false;
		}

		return true;
	}

	// question 7
	public static boolean isMirror(int[][] matrix) {

		int rowSize;
		for (int i = 0; i < matrix.length; i++) {
			rowSize = matrix[i].length;
			for (int j = 0; j < rowSize / 2; j++) {
				if (matrix[i][j] != matrix[i][rowSize - 1 - j]) {
					return false;
				}
			}
		}
		return true;
	}

	// question 8
	public static int[] addArrays(int[] nums1, int[] nums2) {
		int maxLength = nums1.length > nums2.length ? nums1.length : nums2.length;
		int[] sums = new int[maxLength + 1];
		int idx1 = nums1.length - 1, idx2 = nums2.length - 1;
		int counter = 0, sum;

		for (int i = maxLength; i >= 0; i--) {
			sum = counter;
			if (idx1 >= 0) {
				sum += nums1[idx1];
				idx1--;
			}
			if (idx2 >= 0) {
				sum += nums2[idx2];
				idx2--;
			}
			counter = sum / 10;
			sums[i] = sum % 10;
		}
		return sums;
	}

	// question 9
	public static int max0Rectangle(int[][] matrix) {
		int n = matrix.length, minRow = n, minCol = n;

		for (int row = 0; row < minRow; row++) {
			for (int col = 0; col < minCol; col++) {
				if (matrix[row][col] != 0) {
					if (row > col) {
						minRow = row < minRow ? row : minRow;
					} else {
						minCol = col < minCol ? col : minCol;
					}
				}
			}
		}
		return minRow < minCol ? minRow : minCol;
	}

	// question 11
	public static void playMurblePuzzle(int size) {
		char[] arr = new char[2 * size + 1];

		initializeArrayForMurblePuzzle(arr);
		printArray(arr, "start");

		int emptyIdx = 2 * size;
		for (int i = 0; i < size; i++) {
			// X turn
			if (i % 2 == 0) {
				emptyIdx = playTurn(arr, size - i, emptyIdx, -1, 'x', "SR", "JR");
			}
			// O turn
			else {
				emptyIdx = playTurn(arr, size - i, emptyIdx, +1, 'o', "SL", "JL");
			}
		}
	}

	public static void initializeArrayForMurblePuzzle(char[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = i % 2 == 0 ? 'o' : 'x';
		}
	}

	public static void printArray(char[] arr, String info) {
		for (char c : arr) {
			System.out.print(c + " | ");
		}
		System.out.println("      " + info);
	}

	public static int playTurn(char[] arr, int n, int emptyIdx, int shiftDirection, char player, String shiftInfo,
			String jumpInfo) {
		arr[emptyIdx] = player;
		emptyIdx += shiftDirection;
		arr[emptyIdx] = ' ';
		printArray(arr, shiftInfo);
		for (int j = 1; j < n; j++) {
			arr[emptyIdx] = player;
			emptyIdx += 2 * shiftDirection;
			arr[emptyIdx] = ' ';
			printArray(arr, jumpInfo);
		}
		return emptyIdx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		// question 1
		System.out.print("Enter num: ");
		int input = scanner.nextInt();
		int newNum = addOneToEachDigit(input);
		System.out.println("The num is: " + newNum);

		// question 2
		System.out.print("Enter 2 nums: ");
		int input1 = scanner.nextInt();
		int input2 = scanner.nextInt();
		newNum = getSmallestDigitsIfLengthIsEquall(input1, input2);
		System.out.println("The num is: " + newNum);

		// question 3
		for (int i = 1; i <= 10000; i++) {
			if (isPerfect(i)) {
				System.out.println(i);
			}
		}

		// question 4
		System.out.print("Enter num: ");
		input = scanner.nextInt();
		int sum = getSumOfDigits(input);
		System.out.println("The sum is: " + sum);

		int n = 3;
		int[] nums = new int[n];
		System.out.print("Enter " + n + " numbers: ");
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		int num = numOfElementsWithSumOfDigits10(nums);
		System.out.println("The mum of Elements With Sum Of Digits 10: " + num);

		// question 5
		printRhombus('#', 4);

		// question 6
		int[][] matrix = { { 2, 1, 5 }, { 6, 7, 3 }, { 0, 8, 0 } };
		System.out.println("Answer: " + isSumRowEquallToSumCol(matrix));

		// question 7
		matrix = new int[][] { { 2, 1, 5, 1, 2 }, { 6, 7, 3, 7, 6 }, { 0, 8, 0, 8, 0 } };
		System.out.println("Answer: " + isMirror(matrix));

		// question 8
		int[] nums1 = { 9, 9, 9, 9 }, nums2 = { 9, 7 };
		int[] sums = addArrays(nums1, nums2);

		for (int val : sums) {
			System.out.print(val + " ");
		}

		// question 9
		matrix = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println("Max left-top rectangle: " + max0Rectangle(matrix));

		// question 11
		playMurblePuzzle(3);

		scanner.close();
	}
}
