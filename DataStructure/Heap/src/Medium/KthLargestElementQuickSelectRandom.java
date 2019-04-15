package Medium; 
import java.util.Random;
/*
 * This logic can also be used to find median of an unsorted array w/o sorting it. Let kth element be nums.length/2 and don't use shuffle technique
 * In this case expected worst case complexity is O(n), but if random function always select corner elements, then it may be O(n2)
 * Complexity: O(n) and O(1)
 * Worst case: o(n2): if array is sorted in ascending order and we always select first element as pivot
 */
public class KthLargestElementQuickSelectRandom {

	public static void main(String[] args) {
		//int nums[] = {3,3,3,3,3,3,3,3,3};
		int[] nums = {12, 3, 5, 7, 4, 19, 26};	
		int k = 3;
		KthLargestElementQuickSelectRandom objKthLargestElement = new KthLargestElementQuickSelectRandom();
		System.out.println(objKthLargestElement.findKthLargest(nums, k));
	}

	public int findKthLargest(int[] nums, int k)
	{
		// Randomize the array to get complexity O(n) in worst case
		shuffle(nums);
		
		// For Largest
        //k = nums.length - k;
		
		// For kth smallest
		k = k - 1;
        
		int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) 
        {
        	final int j = partition(nums, lo, hi);
        	// If j is less than k (required index), then consider array after j
        	if(j < k) {
                lo = j + 1;
            } 
        	// if j is less than k, then we need to sort only 0 to j-1 array
        	else if (j > k) {
                hi = j - 1;
            } 
        	// If j == k (required index) continue or return
        	else {
                break;
            }
        }
        
        return nums[k];
	}
	
	private int partition(int[] a, int lo, int hi)
	{
		int i = lo + 1;
		int j = hi;
		while(true)
		{
			// Find element greater than lo starting from left
			while (i < hi && a[i] <= a[lo])
				i++;
			
			// Find element less than lo starting from right
			while (j > lo && a[j] >= a[lo])
				j--;
			
			// If they crossed the path, i contains greater ele so no need to exchange
			if (i >= j)
				break;
			exch(a, i, j);
		}
		
		// Exchange lo and j (current smaller ele than lo from right)
		// First element will be sorted
		exch(a, lo, j);
		
		// partition method returns first lo or start element
		return j;
	}
	
	private void shuffle(int a[])
	{
		Random random = new Random();
		for (int ind = 1; ind < a.length; ind++)
		{
			final int r = random.nextInt(ind+1);
			exch(a, ind, r);
		}
	}
	
	private void exch(int[] a, int i, int j)
	{
		final int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}