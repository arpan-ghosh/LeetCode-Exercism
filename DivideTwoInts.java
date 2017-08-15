// Divide two integers without using multiplication, division and mod operator
// If it is overflow, return MAX_INT

public class DivideTwoInts {

	static int MAX_INT = Integer.MAX_VALUE;

	public static int divide(int dividend, int divisor) {
		int count = 1;
		int result = divisor;
		while (result < dividend && result < MAX_INT) {
			result = result + divisor;
			count++;
		}
		System.out.println(count);		
		return count;
	}

	public static void main (String[] args) {
		divide(100,5);
	}

}
