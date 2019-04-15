package Hard;

// Time: O(log(min(m,n))

//Example 1:
//nums1 = [1, 2]
//nums2 = [3, 4]
//The median is (2 + 3)/2 = 2.5

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 3, 5, 8, 9};
		int[] nums2 = new int[] {2, 4, 6, 10, 12};
		MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) 
	{
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        // Keep length of first array greater
        if (len1 > len2) 
            return findMedianSortedArrays(nums2, nums1);
        
        int k = (len1 + len2 + 1) / 2;
        int l = 0;
        int r = len1;
        
        //find the m1 so that nums1[m1] >= nums2[m2 - 1]
        while(l < r)
        {
            int m1 = l + (r - l) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1])
                l = m1 + 1;
            else 
                r = m1;
        }
        
        int m1 = l;
        int m2 = k - l;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 <= 0? Integer.MIN_VALUE: nums2[m2 - 1]);
        
        // If total length is odd, it will be m1-1
        if ((len1 + len2) % 2 ==1) 
            return c1;
        int c2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE : nums1[m1], m2 >= len2 ? Integer.MAX_VALUE: nums2[m2]);
        
        return (c1 + c2) / 2.0;
    }

}
