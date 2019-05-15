//Get Larget Element using Quick Select
/*
 * This logic can also be used to find median of an unsorted array w/o sorting it. Let kth element be nums.length/2 and don't use shuffle technique
 * In this case expected worst case complexity is O(n), but if random function always select corner elements, then it may be O(n2)
 * Complexity: O(n) and O(1)
 * Worst case: o(n2): if array is sorted in ascending order and we always select first element as pivot
 */
//O(N) best case / O(N^2) worst case running time + O(1) memory
package Medium;

import java.util.Random;

public class KthLargestElementInUnsortedArray {
	
	public int findKthLargest(int[] nums, int k) 
    {
        //shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) 
        {
            final int j = partition(nums, lo, hi);
            if(j < k) 
                lo = j + 1;
            else if (j > k) 
                hi = j - 1;
            else 
                break;
        }
        return nums[k];
    }
    
    private int partition(int[] a, int lo, int hi) 
    {
        int i = lo;
        int j = hi + 1;
        while(true) 
        {
        	// Let lo be the pivot
        	// Find an index i from left where a[i] is greater than equal to a[lo] 
            while(i < hi && less(a[++i], a[lo]));
            
            // Find an index j from right where a[j] is smaller than equal to a[lo] 
            while(j > lo && less(a[lo], a[--j]));
            
            // Continue this till i >= j
            if(i >= j) 
                break;
            
            // Exchange i and j
            exch(a, i, j);
        }
        
        // Exchange j and lo
        // Also all elements before j would be less than a[j] and all elements to the right would be greater than equal to aj]
        // So at this point, jth number will get sorted
        exch(a, lo, j);
        return j;
    }
    
    private void exch(int[] a, int i, int j) 
    {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
    
    private void shuffle(int a[]) 
    {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) 
        {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

	public static void main(String[] args) {
		int[]nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		KthLargestElementInUnsortedArray obj = new KthLargestElementInUnsortedArray();
		System.out.println(obj.findKthLargest(nums, k));
	}

}
