package javabootcamp.basic.Ex_5;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// question 1 =================================================================
		int n = 5;
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		String opposite = "";

		System.out.println("array1:");
		for (int i = 0; i < n; i++) {
			arr1[i] = scanner.nextInt();
		}
		System.out.println("array2:");
		for (int i = 0; i < n; i++) {
			arr2[i] = scanner.nextInt();
		}
		for (int i = 0, j = n - 1; i < n; i++, j--) {
			if (arr1[i] != arr2[j]) {
				opposite = "NOT ";
				break;
			}
		}
		System.out.printf("The arrays are %sopposite.", opposite);

		// question 3 =================================================================
		int[] arr = new int[10];
		System.out.println("Enter num1: ");
		arr[0] = scanner.nextInt();
		System.out.println("Enter num2: ");
		arr[1] = scanner.nextInt();
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		for (int element : arr) {
			System.out.print(element + " ");
		}

		// question 5 =================================================================
		boolean isGood = true;
		n = 5;
		arr1 = new int[n];
		arr2 = new int[n];

		System.out.println("array1:");
		for (int i = 0; i < n; i++) {
			arr1[i] = scanner.nextInt();
		}
		System.out.println("array2:");
		for (int i = 0; i < n; i++) {
			arr2[i] = scanner.nextInt();
		}

		int mod;
		for (int i = 0; i < n; i++) {
			mod = (i + 1) % n;
			if (arr1[i] != arr2[mod]) {
				isGood = false;
				break;
			}
		}
		System.out.println("Answer: " + isGood);

		// question 7 =================================================================
		n = 5;
		arr1 = new int[n];
		arr2 = new int[n];
		int[] arr3 = new int[n];
		System.out.println("array1:");
		for (int i = 0; i < n; i++) {
			arr1[i] = scanner.nextInt();
		}
		System.out.println("array2:");
		for (int i = 0; i < n; i++) {
			arr2[i] = scanner.nextInt();
		}

		int count = 0;
		int low, high, mid;
		for (int i = 0, j = 0; i < n; i++) {
			// binary search - best option - log(n)
			low = 0;
			high = n - 1;
			while (low <= high) {
				mid = (low + high) / 2;
				if (arr2[mid] == arr1[i]) {
					arr3[j] = arr1[i];
					count++;
					j++;
					break;
				} else if (arr2[mid] < arr1[i]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		System.out.printf("arr3 has %d numbers:\n", count);
		for (int i = 0; i < count; i++) {
			System.out.print(arr3[i] + " ");
		}

		// question 9 =================================================================
		isGood = true;
		n = 3;
		arr1 = new int[n];
		arr2 = new int[n];
		System.out.println("array1:");
		for (int i = 0; i < n; i++) {
			arr1[i] = scanner.nextInt();
		}
		System.out.println("array2:");
		for (int i = 0; i < n; i++) {
			arr2[i] = scanner.nextInt();
		}

		int sum1, sum2, curr1, curr2;
		for (int i = 0; i < n; i++) {
			curr1 = arr1[i];
			curr2 = arr2[i];
			sum1 = 0;
			sum2 = 0;
			while (curr1 > 0) {
				sum1 += curr1 % 10;
				curr1 /= 10;
			}
			while (curr2 > 0) {
				sum2 += curr2 % 10;
				curr2 /= 10;
			}
			if (sum1 != sum2) {
				isGood = false;
				break;
			}
		}
		System.out.println("Answer: " + isGood);

		// question 11 =================================================================
		n = 10;
		int[][] matrix = new int[n][n];

		int rows;
		System.out.print("Enter rows: ");
		do {
			rows = scanner.nextInt();
			if (rows < 1 || rows > 10) {
				System.out.print("Invalid input. Enter num in range 1 - 10 : ");
			}
		} while (rows < 1 || rows > 10);

		int cols;
		System.out.print("Enter cols: ");
		do {
			cols = scanner.nextInt();
			if (cols < 1 || cols > 10) {
				System.out.print("Invalid input. Enter num in range 1 - 10 : ");
			}
		} while (cols < 1 || cols > 10);

		// Here we have a valid inputs.
		System.out.printf("Enter %d numbers: ", rows * cols);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		int max = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
				if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
					max = matrix[i][j] > max ? matrix[i][j] : max;
				}
			}
			System.out.println("");
		}
		System.out.println("Max: " + max);

		// question 15 =================================================================
		isGood = true;
		System.out.print("Enter matrix size: ");
		n = scanner.nextInt();
		matrix = new int[n][n];
		System.out.printf("Enter %d numbers: ", n * n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
				if (!isGood) {
					continue;
				}
				if (matrix[i][j] != matrix[j][i]) {
					isGood = false;
				}
			}
			System.out.println("");
		}
		System.out.println("The answer: " + isGood);

		scanner.close();
	}
}