package multithreading.concurrency.Executors.ex3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Matrix {
	private int[][] matrix;
	private int rowSize;
	private int colSize;
	private static int[][] mulResult;
	private static Matrix other;

	public Matrix(int size) {
		rowSize = size;
		colSize = size;
		matrix = new int[rowSize][colSize];
		init();
	}

	public Matrix(int[][] matrix) {
		rowSize = matrix.length;
		colSize = matrix[0].length;
		this.matrix = matrix;
	}

	private void init() {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				matrix[i][j] = 1;
			}
		}
	}

	public void print() {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public Matrix mul(Matrix other) {
		int[][] result = new int[other.rowSize][this.colSize];

		for (int i = 0; i < other.rowSize; i++) {
			for (int k = 0; k < this.colSize; k++) {
				for (int j = 0; j < this.colSize; j++) {
					result[i][k] += this.get(i, j) * other.get(j, i);
				}
			}
		}

		return new Matrix(result);
	}

	public Matrix mulParallel(Matrix other) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();

		this.other = other;
		mulResult = new int[other.rowSize][this.colSize];
		for (int i = 0; i < other.rowSize; i++) {
			for (int k = 0; k < this.colSize; k++) {
				service.execute(new MulMatrix(i, k));
			}
		}

		service.shutdown();
		service.awaitTermination(5, TimeUnit.SECONDS);
		return new Matrix(mulResult);
	}

	public int get(int row, int col) {
		return matrix[row][col];
	}
	
	public static boolean isEqualls(Matrix m1, Matrix m2) {
		if(m1.rowSize != m2.rowSize || m1.colSize != m2.colSize) {
			return false;
		}
		
		for (int i = 0; i < m1.rowSize; i++) {
			for (int j = 0; j < m2.rowSize; j++) {
				if(m1.get(i, j) != m2.get(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	public class MulMatrix implements Runnable {
		private int row;
		private int col;

		public MulMatrix(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public void run() {
			for (int i = 0; i < colSize; i++) {
				mulResult[row][col] += get(row, i) * other.get(i, row);
			}
		}
	}
}
