import java.util.Scanner;
public class Matrices {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the number of row: ");
		int row = keyboard.nextInt();
		System.out.println("Enter the number of column: ");
		int column = keyboard.nextInt();
		int[][] matrixA = new int[row][column];
		int[][] matrixB = new int[row][column];
		int[][] sum = new int[row][column];
		System.out.println("Enter matrix A: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrixA[i][j] = keyboard.nextInt();
			}
		}
		System.out.println("Enter matrix B: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrixB[i][j] = keyboard.nextInt();
			}
		}
		System.out.println("The result is: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				sum[i][j] = matrixA[i][j] + matrixB[i][j];
				System.out.print(sum[i][j] + " ");
			}
			System.out.println("");
		}
		keyboard.close();
	}

}
