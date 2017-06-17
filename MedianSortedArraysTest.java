import static org.junit.Assert.*;

import org.junit.Test;

public class MedianSortedArraysTest extends MedianSortedArrays {

	private static final double DELTA = 1e-15;

	// 1,2,3,4,5,6,7,8,9,10
	@Test
	public void testEven() {
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {6,7,8,9,10};
	    double answer = 5.5;
		assertEquals((findMedianSortedArrays(array1, array2)), answer, DELTA);
	}
	
	
	//1,2,4,9,10
	@Test
	public void testOdd() {
		int[] array1 = {2,3};
		int[] array2 = {1};
	    double answer = 2.0;
		assertEquals((findMedianSortedArrays(array1, array2)), answer, DELTA);
	}

}
