
public class MedianSortedArrays {
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		double medianEven = 0;
				
		int[] mergeSorted = new int[nums1.length + nums2.length];
		
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				mergeSorted[k] = nums1[i];
				i++;
			} else {
				mergeSorted[k] = nums2[j];
				j++;
			}
			k++;
		}
		
		if (i < nums1.length) {
			System.arraycopy(nums1, i, mergeSorted, k, (nums1.length - 1));
		}
		
		if (j < nums2.length) {
			System.arraycopy(nums2, j, mergeSorted, k, (nums2.length -1));
		}
		
		// 1,2,3,4,5,6,7,8,9,10
		
		if (mergeSorted.length % 2 == 0) {
			
			double right = (mergeSorted.length / 2) + 1;
			double left = (mergeSorted.length /2);
			medianEven = (right + left) / 2;
			return medianEven;
		} else {
			double medianOdd = mergeSorted[mergeSorted.length/2];
			return medianOdd;
		}
    }

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {6,7,8,9,10}; 
		System.out.print(findMedianSortedArrays(nums1, nums2));
	}

}
