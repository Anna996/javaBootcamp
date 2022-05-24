package multithreading.concurrency.Executors.ex3;

public class Runner {
	private static final int SIZE = 2000;

	public static void main(String[] args) throws InterruptedException {
		Matrix matrixA = new Matrix(SIZE);
		Matrix matrixB = new Matrix(SIZE);
		
//		System.out.println("A: ");
//		matrixA.print();
//		System.out.println("B: ");
//		matrixB.print();
		long startS = System.nanoTime();
		Matrix matrixC = matrixA.mul(matrixB);
		long endS = System.nanoTime();
		System.out.println(endS - startS);
//		System.out.println("serial C: ");
//		matrixC.print();
		long startP = System.nanoTime();
		Matrix matrix = matrixA.mulParallel(matrixB);
		long endP = System.nanoTime();
		System.out.println(endP - startP);
		
	
//		System.out.println("parallel matrix: ");
//		matrix.print();
		
//		boolean isEqual = Matrix.isEqualls(matrixC, matrix);
//		System.out.println("The matrixes is equal? : " + isEqual);
		
		
	}
}