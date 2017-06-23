/*
 * You are given an n x n 2D matrix representing an image.
	
	Rotate the image by 90 degrees (clockwise).
	
	i.e.
	[1][2][3][4]
	[5][6][7][8]
	[9][0][1][2]
	[3][4][5][6]
	
	Becomes:
	[3][9][5][1]
	[4][0][6][2]
	[5][1][7][3]
	[6][2][8][4]
	
 */
public class RotateImage {
	
	public static void rotate(int[][] matrix) {
		
		int row = matrix.length;
		int column = matrix[1].length;
		System.out.println("Row length: " + row);
		System.out.println("Column length: " + column);
		System.out.println();
		
		int[][] rotatedMatrix = new int[column][row];
		int newRow = rotatedMatrix.length;
		int newColumn = rotatedMatrix[1].length;
		System.out.println("Rotated row length: " + newRow);
		System.out.println("Rotated column length: " + newColumn);
		System.out.println();
		
		// print original 2d matrix
		System.out.println("Our original matrix: ");
		System.out.println();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(" ");
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();

		// make rotated 90 degree matrix
		System.out.println("Our 90 degree rotated matrix: ");
		for (int i = 0; i < newRow; i++) {
			int count = rotatedMatrix[1].length;
			for (int j= 0; j < newColumn; j++) {
				count--;
				rotatedMatrix[i][j] = matrix[count][i];
			}		
		}
		
		System.out.println();

		
		// print rotated 2d matrix
				for (int i = 0; i < newRow; i++) {
					for (int j = 0; j < newColumn; j++) {
						System.out.print(" ");
						System.out.print(rotatedMatrix[i][j]);
					}
					System.out.println();
				}
				
				System.out.println();
		
    }
	
	public static void main(String[] args) {
		int[][] test = {{1,2,3,4},{5,6,7,8},{9,0,1,2},{3,4,5,6}};
		int[][] test2 = {{1,2,3},{5,6,7},{9,0,1},{3,4,5}};
		
		System.out.println("**********************************");
		System.out.println("Test 1");
		System.out.println("**********************************");
		rotate(test);
		System.out.println("**********************************");
		System.out.println("Test 2");
		System.out.println("**********************************");
		rotate(test2);
	}
}
