import java.util.*;

public class arrays1
{
public static void main(String[] args)
{
	int num = 6;
	int[] numbers, n;	// array reference variables

	final int NSIZE = 10;
	numbers = new int[NSIZE]; // get 10 int memory locations

	numbers[0] = 20;
	numbers[5] = num;

	int result = 1;	
	for (int i=0; i < NSIZE; i++)
	{	numbers[i] = result;
		result *= 2;
	}

	System.out.println(numbers);   // get memory address
	printIntegers(numbers);

	double d, des[] = {4.3, 5.4, 6.5, 7.6};
	d = 24;
	roots(des, d);
	for (int i=0; i < 4; i++)
		System.out.print(des[i] + " ");
	System.out.println(d);

	doublesize(des);  // ineffective
	des = doublesize(des);  // must do something with return value
	System.out.println(des[des.length-1]);

	Random rand = new Random();
	final int ROWS = 4, COLS = 8;
	boolean tt[][] = new boolean[ROWS][COLS];

	System.out.println("tt.length is: " + tt.length);  // # rows
    System.out.println("#columns in 1st row: " + tt[0].length);

	for (int r=0; r < ROWS; r++)
		for (int c=0; c < COLS; c++)
			tt[r][c] = rand.nextBoolean();
	printBools(tt);
	System.out.println();

	// make 2nd row the ! of the first row
	for (int c=0; c < COLS; c++)
		tt[1][c] = ! tt[0][c];

	// make the 3rd row the && of the first row
	for (int c=0; c < COLS-1; c++)
		tt[2][c] = tt[0][c] && tt[0][c+1];
	tt[2][COLS-1] = tt[0][COLS-1] && tt[0][0];

	// make the 4th row the || of the first row
	for (int c=0; c < COLS-1; c++)
		tt[3][c] = tt[0][c] || tt[0][c+1];
	tt[3][COLS-1] = tt[0][COLS-1] || tt[0][0];
	printBools(tt);

	// make or of first column
	boolean res = false;
	for (int r=0; r < ROWS; r++)
		res = res || tt[r][0];
	System.out.println("OR of first column is " + res);

	// make multiplication table
	final int MAX = 12;
	int[][] mult = new int[MAX][MAX];
	for (int r=0; r < MAX; r++)
		for (int c=0; c < MAX; c++)
			mult[r][c] = (r+1)*(c+1);

	// print multiplication table
	System.out.print(" X | ");
	for (int c=1; c <= MAX; c++)
		System.out.printf("%5d", c);
	System.out.println();
	for (int c=0; c <= MAX; c++)
		System.out.print("-----");
	System.out.println();
	for (int r=0; r < MAX; r++)
	{	System.out.printf("%2d | ", r+1);
		for (int c=0; c < MAX; c++)
			System.out.printf("%5d", mult[r][c]);
		System.out.println();
	}
}	

public static void printBools(boolean[][] ra)
{
	for (int r=0; r < ra.length; r++)	// #rows
	{	for (int c=0; c < ra[r].length; c++)
			System.out.print(ra[r][c] + " ");
		System.out.println();
	}
}

public static void printIntegers(int[] ra)
{
	for (int i=0; i < ra.length; i++)
		System.out.println(ra[i]);
}

public static void roots(double[] ra, double d)
{
	for (int i=0; i < ra.length; i++)
		ra[i] = Math.sqrt(ra[i]);
	d = Math.sqrt(d);
}

public static double[] doublesize(double[] ra)
{
	//NOT:	ra.length = ra.length * 2;

	double[] temp = new double[ra.length*2];
	for (int i=0; i < ra.length; i++)
		temp[i] = ra[i];
	ra = temp;  // not going to affect the calling array (des)
	return temp;
}
}